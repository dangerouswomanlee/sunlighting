package com.company.site.controller;

import com.company.site.model.Contact;
import com.company.site.service.AdminService;
import com.company.site.service.ContactService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final ContactService contactService;

    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        if (adminService.login(username, password)) {
            session.setAttribute("admin", true);
            return "redirect:/admin/contact/list";
        }

        model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
        return "admin-login";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }

    // 관리자 문의 목록
    @GetMapping("/contact/list")
    public String adminList(HttpSession session, Model model) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        model.addAttribute("list", contactService.findAll());
        return "admin-contact-list";
    }

    // 관리자 문의 상세 페이지
    @GetMapping("/contact/{id}")
    public String adminDetail(@PathVariable Long id, HttpSession session, Model model) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        Contact contact = contactService.findById(id).orElse(null);
        if (contact == null) return "redirect:/admin/contact/list";

        model.addAttribute("contact", contact);
        return "admin-contact-detail";
    }

    // 관리자 답글 등록
    @PostMapping("/contact/{id}/reply")
    public String reply(@PathVariable Long id,
                        @RequestParam String reply,
                        HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }

        Contact contact = contactService.findById(id).orElse(null);
        if (contact == null) return "redirect:/admin/contact/list";

        contact.setAdminReply(reply);
        contact.setReplyAt(LocalDateTime.now());

        contactService.save(contact);

        return "redirect:/admin/contact/" + id;
    }
}
