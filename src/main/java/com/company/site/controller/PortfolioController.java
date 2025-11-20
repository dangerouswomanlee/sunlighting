package com.company.site.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {

    // 포트폴리오 목록 
    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    // 포트폴리오 상세 
    @GetMapping("/portfolio/detail")
    public String portfolioDetail(@RequestParam("id") String id, Model model) {

        model.addAttribute("id", id);

        return "portfolio_detail";
    }
}