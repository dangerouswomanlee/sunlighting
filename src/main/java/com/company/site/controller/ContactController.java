package com.company.site.controller;

import com.company.site.model.Contact;
import com.company.site.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    // 문의 목록
    @GetMapping("/contact")
    public String list(Model model) {
        model.addAttribute("list", contactService.findAll());
        return "contact-list";
    }

    // 문의 작성 페이지
    @GetMapping("/contact/write")
    public String write() {
        return "contact-write";
    }

    // 문의 저장
    @PostMapping("/contact/write")
    public String writeSubmit(Contact contact) {
        contactService.save(contact);
        return "redirect:/contact";
    }

    // 글 비밀번호 입력 페이지
    @GetMapping("/contact/{id}")
    public String passwordPage(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "contact-password";
    }

    // 비밀번호 검증 후 상세 페이지 이동
    @PostMapping("/contact/{id}")
    public String validatePassword(@PathVariable Long id,
                                   @RequestParam String password,
                                   Model model) {

        Contact contact = contactService.findById(id).orElse(null);

        if (contact == null) return "redirect:/contact";

        if (!contactService.checkPassword(contact, password)) {
            model.addAttribute("id", id);
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "contact-password";
        }

        model.addAttribute("contact", contact);
        return "contact-detail";
    }
    
}
