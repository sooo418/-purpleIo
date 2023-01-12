package com.purple.hw.domain;

import java.time.LocalDateTime;

public class Vimeo extends Embed {
    private String title;
    private String is_plus;
    private String account_type;
    private int duration;
    private String description;
    private int thumbnail_height;
    private int thumbnail_width;
    private String thumbnail_url;
    private String thumbnail_url_with_play_button;
    private String upload_date;
    private int video_id;
    private String uri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIs_plus() {
        return is_plus;
    }

    public void setIs_plus(String is_plus) {
        this.is_plus = is_plus;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
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

    public int getThumbnail_height() {
        return thumbnail_height;
    }

    public void setThumbnail_height(int thumbnail_height) {
        this.thumbnail_height = thumbnail_height;
    }

    public int getThumbnail_width() {
        return thumbnail_width;
    }

    public void setThumbnail_width(int thumbnail_width) {
        this.thumbnail_width = thumbnail_width;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getThumbnail_url_with_play_button() {
        return thumbnail_url_with_play_button;
    }

    public void setThumbnail_url_with_play_button(String thumbnail_url_with_play_button) {
        this.thumbnail_url_with_play_button = thumbnail_url_with_play_button;
    }

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
