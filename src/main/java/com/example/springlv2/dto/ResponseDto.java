package com.example.springlv2.dto;

import lombok.Getter;

@Getter
public class ResponseDto {

    private final String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
