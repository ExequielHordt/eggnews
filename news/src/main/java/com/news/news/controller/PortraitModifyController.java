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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("/modifyImage")
public class PortraitModifyController {

    @Autowired
    NewsService service;

    @GetMapping("/{id}")
    public String modifyPortrait(@PathVariable Long id, ModelMap model) {
        try {
            model.put("Report", service.byId(id));
            return "modifyImage";
        } catch (Exception e) {
            return "modifyNews";
        }
    }

    @PostMapping("/{id}")
    public String modifyPortrait(@PathVariable Long id, @RequestParam String portrait, ModelMap model, RedirectAttributes error) {
        try {
            service.update(id, service.byId(id).getTitle(), portrait, service.byId(id).getBody());
            model.put("success", "La portada se ha modificado correctamente");
            return "modifyNews";
        } catch (Exception e) {
            error.addFlashAttribute("error", e.getMessage());
            return "redirect:/modifyImage/{id}";
        }

    }

    @GetMapping("/adminPanel")
    public String adminPanelPage() {
        return "redirect:../adminPanel";
    }

    @GetMapping("/home")
    public String reHomePage() {
        return "redirect:/";
    }
}