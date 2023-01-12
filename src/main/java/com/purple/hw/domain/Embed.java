package com.purple.hw.domain;

import org.thymeleaf.util.StringUtils;

public class Embed {
    private static final String YOUTUBE = "youtube";
    private static final String VIMEO = "vimeo";
    private static final String TWITTER = "twitter";

    private String url;
    private String author_name;
    private String author_url;
    private String type;
    private int height;
    private int width;
    private String version;
    private String provider_name;
    private String provider_url;
    private String html;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
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

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_url() {
        return provider_url;
    }

    public void setProvider_url(String provider_url) {
        this.provider_url = provider_url;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public static Class<? extends Embed> getClass(String channel) {
        if ( StringUtils.equalsIgnoreCase(channel, YOUTUBE) ) {
            return Youtube.class;
        } else if ( StringUtils.equalsIgnoreCase(channel, VIMEO) ) {
            return Vimeo.class;
        } else if ( StringUtils.equalsIgnoreCase(channel, TWITTER) ) {
            return Twitter.class;
        }
        return null;
    }
}
