package com.news.news.controller;

import com.news.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("/modifyBody")
public class BodyModifyController {

    @Autowired
    private NewsService service;

    @GetMapping("/{id}")
    public String modifyBodyPage(@PathVariable Long id, ModelMap model) {
        try {
            model.put("report", service.byId(id));
            return "modifyBody";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            return "modifyNews";
        }
    }
    
    @PostMapping("/{id}")
    public String modify(@PathVariable Long id, ModelMap model, RedirectAttributes error){
        try {
            model.put("success", "¡El contenido de la noticia ha sido modificado con éxito!");
            return "modifyNews";
        } catch (Exception e) {
            error.addAttribute("error", e.getMessage());
            return "redirect:/modifyBody/{id}";
        }
    }

    @GetMapping("/adminPanel")
    public String adminPanelPage() {
        return "redirect:/adminPanel";
    }

    @GetMapping("/home")
    public String HomePage() {
        return "redirect:/";
    }
}
