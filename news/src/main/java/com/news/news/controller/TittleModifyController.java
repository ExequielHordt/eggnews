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
@RequestMapping("/modifyTittle")
public class TittleModifyController {

    @Autowired
    private NewsService service;

    @GetMapping("/{id}")
    public String modifyTittlePage(@PathVariable Long id, ModelMap model) {
        try {
            model.put("report", service.byId(id));
            return "modifyTittle";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            return "modifyNews";
        }
    }

    @PostMapping("{id}")
    public String modify(@PathVariable Long id, @RequestParam String title, ModelMap model, RedirectAttributes error) {
        try {
            service.update(id, title, service.byId(id).getPortrait(), service.byId(id).getBody());
            model.put("success", "¡El titulo ha sido modificado correctamente!");
            return "modifyNews";
        } catch (Exception e) {
            error.addFlashAttribute("error", e.getMessage());
            return "redirect:/modifyTittle/{id}";
        }
    }

    @GetMapping("/adminPanel")
    public String adminPanel() {
        return "redirect:/adminPanel";
    }

    @GetMapping("/home")
    public String HomePage() {
        return "redirect:/";
    }
}
