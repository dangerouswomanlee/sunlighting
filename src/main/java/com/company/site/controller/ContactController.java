package com.company.site.controller;

import com.company.site.model.Contact;
import com.company.site.service.ContactService;
import com.company.site.service.LoginAttemptService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final LoginAttemptService loginAttemptService;

    @GetMapping("/contact")
    public String list(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("list", contactService.search(keyword));
        model.addAttribute("keyword", keyword != null ? keyword : "");
        return "contact-list";
    }

    @GetMapping("/contact/write")
    public String write(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-write";
    }

    @PostMapping("/contact/write")
    public String writeSubmit(@Valid Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact-write";
        }
        contactService.save(contact);
        return "redirect:/contact";
    }

    @GetMapping("/contact/{id}")
    public String passwordPage(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "contact-password";
    }

    @PostMapping("/contact/{id}")
    public String validatePassword(@PathVariable Long id,
                                   @RequestParam String password,
                                   HttpServletRequest request,
                                   Model model) {

        String attemptKey = "contact-password:" + request.getRemoteAddr() + ":" + id;

        if (loginAttemptService.isBlocked(attemptKey)) {
            model.addAttribute("id", id);
            model.addAttribute("error", "시도가 너무 많습니다. 10분 후 다시 시도해주세요.");
            return "contact-password";
        }

        Contact contact = contactService.findById(id).orElse(null);

        if (contact == null) return "redirect:/contact";

        if (!contactService.checkPassword(contact, password)) {
            loginAttemptService.loginFailed(attemptKey);
            model.addAttribute("id", id);
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "contact-password";
        }

        loginAttemptService.reset(attemptKey);
        model.addAttribute("contact", contact);
        return "contact-detail";
    }
    
}
