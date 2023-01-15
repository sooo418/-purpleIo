package com.purple.hw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Youtube extends Embed {
    private String title;
    @JsonProperty("thumbnail_height")
    private int thumbnailHeight;
    @JsonProperty("thumbnail_width")
    private int thumbnailWidth;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public int getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
