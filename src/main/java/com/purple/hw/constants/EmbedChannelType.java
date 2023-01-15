package com.purple.hw.constants;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Arrays.stream;

public enum EmbedChannelType {
    YOUTUBE("01", "youtube"),
    TWITTER("02", "twitter"),
    VIMEO("03", "vimeo");

    final String code;
    final String name;

    EmbedChannelType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualTo(EmbedChannelType embedChannelType) {
        return getCode().equals(embedChannelType.getCode());
    }

    public static EmbedChannelType valueOfCode(String code) {
        Optional<EmbedChannelType> findType = stream(EmbedChannelType.values()).filter(e -> e.code.equals(code)).findAny();
        return findType.orElseThrow(NoSuchElementException::new);
    }

    public static EmbedChannelType getUrlEmbedType(String url) {
        Optional<EmbedChannelType> urlEmbedType = stream(EmbedChannelType.values())
                .filter(e -> url.toLowerCase().contains(e.getName()))
                .findAny();
        return urlEmbedType.orElseThrow(NoSuchElementException::new);
    }
}
