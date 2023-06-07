package com.news.news.controller;

import com.news.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("/removeNews")
public class RemoveNewsController {

    @Autowired
    private NewsService service;

    @GetMapping("removeNews")
    public String removePage() {
        return "removeNews";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) Long id, ModelMap model) {
        try {
            model.addAttribute("report", service.byId(id));
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "removeNews";
    }

    @PostMapping("/{id}")
    public String remove(@PathVariable Long id, ModelMap model) {
        try {
            service.delete(id);
            model.put("success", "¡La noticia con id " + id + " ha sido eliminada con éxito!");
        } catch (Exception e) {
            model.put("error", e.getMessage());
        }
        return "removeNews";
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
