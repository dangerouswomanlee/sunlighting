package com.company.site.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // /contact/abc 처럼 Long 이 아닌 경로 변수가 들어온 경우
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, NoResourceFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(HttpServletRequest request, Exception e) {
        log.warn("404 Not Found: {}", request.getRequestURI());
        return "error/404";
    }

    // DB 오류, NullPointerException 등 예상치 못한 서버 오류
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleServerError(HttpServletRequest request, Exception e) {
        log.error("500 Internal Server Error: {}", request.getRequestURI(), e);
        return "error/500";
    }
}
