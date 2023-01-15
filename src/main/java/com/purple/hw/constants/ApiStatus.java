package com.purple.hw.constants;

import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Arrays.stream;

public enum ApiStatus {
    OK("200", "OK"),
    BAD_REQUEST("400", "Bad Reqeust"),
    FORBIDDEN("403", "Fordidden"),
    INTERNAL_SERVER_ERROR("500", "Interal Server Error");

    final String status;
    final String message;

    ApiStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isEqualTo(ApiStatus apiStatus) {
        return getStatus().equals(apiStatus.getStatus());
    }

    public static ApiStatus valueOfStatus(String status) {
        Optional<ApiStatus> findStatus = stream(ApiStatus.values()).filter(a -> a.status.equals(status)).findAny();
        return findStatus.orElse(INTERNAL_SERVER_ERROR);
    }
}
