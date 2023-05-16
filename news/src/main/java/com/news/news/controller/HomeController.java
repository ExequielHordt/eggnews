package com.news.news.controller;

import com.news.news.entity.News;
import com.news.news.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private NewsService service;

    @GetMapping("/")
    public String homePage(ModelMap model) {
        List<News> reports = service.findAll();
        model.addAttribute("reports", reports);
        return "home";
    }

    @GetMapping("/home")
    public String reHomePage() {
        return "redirect:/";
    }

    @GetMapping("/adminPanel")
    public String adminPanelPage() {
        return "adminPanel";
    }
}
