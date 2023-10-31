package com.example.springlv2.dto;

import com.example.springlv2.entity.borrowRecord.BorrowRecord;
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

    public BorrowRecordDto(
        Long id,
        String name,
        String phoneNumber,
        String title,
        String author,
        LocalDateTime borrowedAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.author = author;
        this.borrowedAt = borrowedAt;
    }
}
