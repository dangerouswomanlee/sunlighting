package com.company.site.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {

    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    @GetMapping("/portfolio/detail")
    public String portfolioDetail(@RequestParam("id") String id, Model model) {

        model.addAttribute("id", id);

        return "portfolio_detail";
    }
}