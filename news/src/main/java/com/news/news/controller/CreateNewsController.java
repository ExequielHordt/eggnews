package com.news.news.controller;

import com.news.news.entity.News;
import com.news.news.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("createNews")
public class CreateNewsController {

    @Autowired
    private NewsService service;

    @GetMapping("createNews")
    public String createNewsPage(ModelMap model) {
        List<News> news = service.findAll();
        model.addAttribute("News", news);
        return "createNews";
    }

    @PostMapping("/create")
    public String create(@RequestParam String tittle, @RequestParam String portrait,
            @RequestParam String body, ModelMap model) {
        try {
            service.create(tittle, portrait, body);
            model.put("success", "¡La noticia fue creada con éxito!");
            return "redirect:/";
        } catch (Exception ex) {
            model.put("error", ex.getMessage());
            return "createNews";
        }
    }

    @GetMapping("/home")
    public String homePage() {
        return "redirect:/";
    }

    @GetMapping("/adminPanel")
    public String adminPanelPage() {
        return "adminPanel";
    }
}
