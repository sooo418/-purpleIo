package com.purple.hw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vimeo extends Embed {
    private String title;
    @JsonProperty("is_plus")
    private String isPlus;
    @JsonProperty("account_type")
    private String accountType;
    private int duration;
    private String description;
    @JsonProperty("thumbnail_height")
    private int thumbnailHeight;
    @JsonProperty("thumbnail_width")
    private int thumbnailWidth;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    @JsonProperty("thumbnail_url_with_play_button")
    private String thumbnailUrlWithPlayButton;
    @JsonProperty("upload_date")
    private String uploadDate;
    @JsonProperty("video_id")
    private int videoId;
    private String uri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsPlus() {
        return isPlus;
    }

    public void setIsPlus(String isPlus) {
        this.isPlus = isPlus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getThumbnailUrlWithPlayButton() {
        return thumbnailUrlWithPlayButton;
    }

    public void setThumbnailUrlWithPlayButton(String thumbnailUrlWithPlayButton) {
        this.thumbnailUrlWithPlayButton = thumbnailUrlWithPlayButton;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
