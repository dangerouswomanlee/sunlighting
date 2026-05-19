package com.company.site.controller;

import com.company.site.model.Contact;
import com.company.site.service.AdminService;
import com.company.site.service.ContactService;
import com.company.site.service.LoginAttemptService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/xk9b4m7")
public class AdminController {

    private final AdminService adminService;
    private final ContactService contactService;
    private final LoginAttemptService loginAttemptService;

    @GetMapping("/login")
    public String loginPage() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request,
                        Model model) {

        if (loginAttemptService.isBlocked(username)) {
            model.addAttribute("error", "로그인 시도가 너무 많습니다. 10분 후 다시 시도해주세요.");
            return "admin-login";
        }

        if (adminService.login(username, password)) {
            loginAttemptService.reset(username);

            // 세션 고정 공격 방어: 기존 세션 무효화 후 새 세션 생성
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) oldSession.invalidate();
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("admin", true);

            return "redirect:/xk9b4m7/contact/list";
        }

        loginAttemptService.loginFailed(username);
        int remaining = loginAttemptService.getRemainingAttempts(username);

        if (remaining <= 0) {
            model.addAttribute("error", "로그인 시도가 너무 많습니다. 10분 후 다시 시도해주세요.");
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다. (남은 시도: " + remaining + "회)");
        }
        return "admin-login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/xk9b4m7/login";
    }

    @GetMapping("/contact/list")
    public String adminList(HttpSession session, Model model) {
        if (!Boolean.TRUE.equals(session.getAttribute("admin"))) {
            return "redirect:/xk9b4m7/login";
        }
        model.addAttribute("list", contactService.findAll());
        return "admin-contact-list";
    }

    @GetMapping("/contact/{id}")
    public String adminDetail(@PathVariable Long id, HttpSession session, Model model) {
        if (!Boolean.TRUE.equals(session.getAttribute("admin"))) {
            return "redirect:/xk9b4m7/login";
        }
        Contact contact = contactService.findById(id).orElse(null);
        if (contact == null) return "redirect:/xk9b4m7/contact/list";
        model.addAttribute("contact", contact);
        return "admin-contact-detail";
    }

    @PostMapping("/contact/{id}/delete")
    public String delete(@PathVariable Long id, HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("admin"))) {
            return "redirect:/xk9b4m7/login";
        }
        contactService.delete(id);
        return "redirect:/xk9b4m7/contact/list";
    }

    @PostMapping("/contact/{id}/reply")
    public String reply(@PathVariable Long id,
                        @RequestParam String reply,
                        HttpSession session) {
        if (!Boolean.TRUE.equals(session.getAttribute("admin"))) {
            return "redirect:/xk9b4m7/login";
        }
        Contact contact = contactService.findById(id).orElse(null);
        if (contact == null) return "redirect:/xk9b4m7/contact/list";

        contact.setAdminReply(reply);
        contact.setReplyAt(LocalDateTime.now());
        contactService.save(contact);

        return "redirect:/xk9b4m7/contact/" + id;
    }
}
