package com.purple.hw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Twitter extends Embed {
    @JsonProperty("cache_age")
    private String cacheAge;

    public String getCacheAge() {
        return cacheAge;
    }

    public void setCacheAge(String cacheAge) {
        this.cacheAge = cacheAge;
    }
}
