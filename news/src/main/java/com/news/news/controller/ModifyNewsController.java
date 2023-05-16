package com.news.news.controller;

import com.news.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("modifyNews")
public class ModifyNewsController {

    @Autowired
    private NewsService service;

    @GetMapping("modifyNews")
    public String modifyNewsPage() {
        return "modifyNews";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) Long id, ModelMap model) {
        try {
            model.addAttribute("Report", service.byId(id));
            model.put("Result", service.byId(id));
            if (model.getAttribute("Result") == null) {
                model.put("searchNull", "El ID ingresado no se corresponde a ninguna noticia de nuestra base de datos");
            }
            return "modifyNews";
        } catch (Exception e) {
            model.put("error", e.getMessage());
            return "modifyNews";
        }

    }

    @GetMapping("/adminPanel")
    public String adminPanelPage() {
        return "adminPanel";
    }

    @GetMapping("/home")
    public String HomePage() {
        return "/";
    }

    @GetMapping("/modifyImage/{id}")
    public String modifyPortrait() {

        return "redirect:/modifyImage/{id}";

    }

    @GetMapping("/modifyTittle/{id}")
    public String modifyTittle() {
        return "redirect:/modifyTittle/{id}";
    }

    @GetMapping("/modifyBody/{id}")
    public String modifyBody() {
        return "redirect:/modifyBody/{id}";
    }
}
/*/modifyImage/{id}*/
