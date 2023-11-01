package com.example.springlv2.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BorrowRecordDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String title;
    private String author;
    private LocalDateTime borrowedAt;
    private boolean returnStatus;


    public BorrowRecordDto(
        Long id,
        String name,
        String phoneNumber,
        String title,
        String author,
        LocalDateTime borrowedAt, boolean returnStatus) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.author = author;
        this.borrowedAt = borrowedAt;
        this.returnStatus = returnStatus;
    }
}
