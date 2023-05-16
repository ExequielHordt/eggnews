package com.news.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Exequiel Hordt
 * @version 19 Mar 2023
 */
@Controller
@RequestMapping("adminPanel")
public class AdminPanelController {

    @GetMapping("adminPanel")
    public String adminPanelPage() {
        return "adminPanel";
    }

    @GetMapping("/createNews")
    public String createNewsPage() {
        return "createNews";
    }

    @GetMapping("/modifyNews")
    public String modifyNewsPage() {
        return "modifyNews";
    }

    @GetMapping("/removeNews")
    public String removeNewsPage() {
        return "removeNews";
    }

    @GetMapping("/home")
    public String reHomePage() {
        return "/";
    }
}
