package com.purple.hw.controller;

import com.purple.hw.domain.Embed;
import com.purple.hw.service.EmbedService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/search")
    @ResponseBody
    public Embed getEmbedInf(Embed embed) {
        embed = embedService.getEmbedInf(embed);
        return embed;
    }
}
