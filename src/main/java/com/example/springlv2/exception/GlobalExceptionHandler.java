package com.example.springlv2.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger("글로벌 예외 처리");

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        logger.info("에러 처리 로깅");

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error type", httpStatus.getReasonPhrase());
        errorMap.put("code", "400");
        errorMap.put("message", e.getMessage());

        return ResponseEntity.status(httpStatus)
            .headers(responseHeaders)
            .body(errorMap);
//        return new ResponseEntity<>(errorMap, responseHeaders, httpStatus);
    }
}
