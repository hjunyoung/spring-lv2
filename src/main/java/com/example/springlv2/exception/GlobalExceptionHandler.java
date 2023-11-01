package com.example.springlv2.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger("글로벌 예외 처리");

    private final HttpHeaders responseHeaders = new HttpHeaders();

    private final Map<String, String> errorMap = new HashMap<>();

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> IllegalArgumentExceptionHandler(
        IllegalArgumentException e) {
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        logger.info("에러 처리 로깅");

        errorMap.put("error type", httpStatus.getReasonPhrase());
        errorMap.put("code", "400");
        errorMap.put("message", e.getMessage());

        return ResponseEntity.status(httpStatus)
            .headers(responseHeaders)
            .body(errorMap);
//        return new ResponseEntity<>(errorMap, responseHeaders, httpStatus);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler(
        MethodArgumentNotValidException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        logger.info("유효성 검사 에러 처리 로깅");

        errorMap.put("error type", httpStatus.getReasonPhrase());
        errorMap.put("code", "400");
        errorMap.put("message", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return ResponseEntity.status(httpStatus)
            .headers(responseHeaders)
            .body(errorMap);
    }
}
