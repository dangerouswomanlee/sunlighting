package com.company.site.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtUtil {

    private final SecretKey signingKey;
    private final int expirationHours;
    private final boolean cookieSecure;

    // jti -> expiry, tokens revoked via logout before their natural expiration
    private final Map<String, Instant> revokedTokenIds = new ConcurrentHashMap<>();

    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration-hours}") int expirationHours,
            @Value("${jwt.cookie-secure}") boolean cookieSecure) {
        this.signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationHours = expirationHours;
        this.cookieSecure = cookieSecure;
    }

    public String generateToken() {
        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .subject("admin")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationHours * 3_600_000L))
                .signWith(signingKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser().verifyWith(signingKey).build().parseSignedClaims(token).getPayload();
            return !revokedTokenIds.containsKey(claims.getId());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public void revokeToken(String token) {
        try {
            Claims claims = Jwts.parser().verifyWith(signingKey).build().parseSignedClaims(token).getPayload();
            revokedTokenIds.put(claims.getId(), claims.getExpiration().toInstant());
            revokedTokenIds.values().removeIf(expiry -> expiry.isBefore(Instant.now()));
        } catch (JwtException | IllegalArgumentException e) {
            // already invalid, nothing to revoke
        }
    }

    public ResponseCookie createAuthCookie(String token) {
        return ResponseCookie.from("admin_token", token)
                .httpOnly(true)
                .secure(cookieSecure)
                .path("/xk9b4m7")
                .maxAge(Duration.ofHours(expirationHours))
                .sameSite("Strict")
                .build();
    }

    public ResponseCookie clearAuthCookie() {
        return ResponseCookie.from("admin_token", "")
                .httpOnly(true)
                .secure(cookieSecure)
                .path("/xk9b4m7")
                .maxAge(0)
                .sameSite("Strict")
                .build();
    }
}
