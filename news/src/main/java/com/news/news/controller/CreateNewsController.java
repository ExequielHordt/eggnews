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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String create(@RequestParam String title, @RequestParam String portrait,
            @RequestParam String body, RedirectAttributes redirectAttributes) {
        try {
            service.create(title, portrait, body);
            redirectAttributes.addFlashAttribute("success", "¡La noticia fue creada con éxito!");
            return "redirect:/";
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/createNews/createNews";
        }
    }

    @GetMapping("/")
    public String home() {
        return "/";
    }

    @GetMapping("/adminPanel")
    public String adminPanelPage() {
        return "adminPanel";
    }
}
