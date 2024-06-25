package com.bevis.adminservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bevis.adminservice.dto.response.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ApiResponse<?> handleThrowable(Throwable ex) {
        log.error("error throwable is: ", ex);
        ApiResponse<?> response = new ApiResponse<>();
        return response;
    }
}
