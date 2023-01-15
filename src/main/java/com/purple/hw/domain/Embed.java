package com.purple.hw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.purple.hw.constants.EmbedChannelType;
import org.thymeleaf.util.StringUtils;

public class Embed {
    private static final String YOUTUBE = "youtube";
    private static final String VIMEO = "vimeo";
    private static final String TWITTER = "twitter";

    private String url;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_url")
    private String authorUrl;
    private String type;
    private int height;
    private int width;
    private String version;
    @JsonProperty("provider_name")
    private String providerName;
    @JsonProperty("provider_url")
    private String providerUrl;
    private String html;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public static Class<? extends Embed> getClass(EmbedChannelType embedChannelType) {
        if ( EmbedChannelType.YOUTUBE.isEqualTo(embedChannelType) ) {
            return Youtube.class;
        } else if ( EmbedChannelType.TWITTER.isEqualTo(embedChannelType) ) {
            return Twitter.class;
        } else if ( EmbedChannelType.VIMEO.isEqualTo(embedChannelType) ) {
            return Vimeo.class;
        }
        return null;
    }
}
