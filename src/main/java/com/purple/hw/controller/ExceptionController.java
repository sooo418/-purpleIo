package com.purple.hw.controller;

import com.purple.hw.constants.ApiStatus;
import com.purple.hw.domain.ApiResponse;
import com.purple.hw.domain.Embed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.NoSuchElementException;

@RestControllerAdvice("com.purple.hw")
public class ExceptionController {
    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(NullPointerException.class)
    public ApiResponse nullPointException(Exception e) {
        errorLog(e);
        ApiStatus apiStatus = ApiStatus.INTERNAL_SERVER_ERROR;
        return new ApiResponse(apiStatus.getStatus(), apiStatus.getMessage(), new Embed());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ApiResponse noSuchElementException(Exception e) {
        errorLog(e);
        ApiStatus apiStatus = ApiStatus.BAD_REQUEST;
        return new ApiResponse(apiStatus.getStatus(), apiStatus.getMessage(), new Embed());
    }

    @ExceptionHandler(IOException.class)
    public ApiResponse IOException(Exception e) {
        errorLog(e);
        ApiStatus apiStatus = ApiStatus.INTERNAL_SERVER_ERROR;

        if ( !StringUtils.isEmpty(e.getMessage()) ) {
            apiStatus = ApiStatus.valueOfStatus(e.getMessage());

            return new ApiResponse(apiStatus.getStatus(), apiStatus.getMessage(), new Embed());
        }

        return new ApiResponse(apiStatus.getStatus(), apiStatus.getMessage(), new Embed());
    }

    private void errorLog(Exception e) {
        int line = e.getStackTrace()[0].getLineNumber();
        String methodName = e.getStackTrace()[0].getMethodName();
        logger.error("Error : {}, line : {}, Method name : {}", e.toString(), line, methodName);
    }
}
