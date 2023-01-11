package com.purple.hw.controller;

import com.purple.hw.domain.Embed;
import com.purple.hw.service.EmbedService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmbedController {
    private final EmbedService embedService;

    public EmbedController(EmbedService embedService) {
        this.embedService = embedService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/search")
    public String getEmbedInf(Embed embed, Model model) {
        embed = embedService.getEmbedInf(embed);
        model.addAttribute("embed", embed);
        return "home";
    }
}
