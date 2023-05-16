package com.news.news.controller;

import com.news.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping("/{id}")
    public String newsPage(@PathVariable Long id, ModelMap model) {
        try {
            model.put("report", service.byId(id));
            return "news";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("/adminPanel")
    public String adminPanelPage() {
        return "adminPanel";
    }

    @GetMapping("/home")
    public String HomePage() {
        return "redirect:/";
    }

}
