package com.purple.hw.domain;

import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class EmbedFactory {
    private final String YOUTUBE = "youtube";
    private final String VIMEO = "vimeo";
    private final String TWITTER = "twitter";
    public Embed createEmbed(String channel) {
        if ( StringUtils.isEmpty(channel) ) {
            return null;
        }

        if ( StringUtils.equalsIgnoreCase(channel, YOUTUBE) ) {
            return new Youtube();
        } else if ( StringUtils.equalsIgnoreCase(channel, VIMEO) ) {
            return new Vimeo();
        } else if ( StringUtils.equalsIgnoreCase(channel, TWITTER) ) {
            return new Twitter();
        }

        return null;
    }
}
