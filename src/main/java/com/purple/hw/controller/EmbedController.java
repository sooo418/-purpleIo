package com.purple.hw.controller;

import com.purple.hw.constants.ApiStatus;
import com.purple.hw.domain.ApiResponse;
import com.purple.hw.domain.Embed;
import com.purple.hw.service.EmbedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ApiResponse getEmbedInf(Embed embed) throws Exception {
        embed = embedService.getEmbedInf(embed);
        return new ApiResponse(ApiStatus.OK.getStatus(), ApiStatus.OK.getMessage(), embed);
    }
}
