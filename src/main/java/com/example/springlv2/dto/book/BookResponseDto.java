package com.example.springlv2.dto.book;

import com.example.springlv2.entity.book.Book;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class BookResponseDto {

    private final Long id;
    private final String title;
    private final String author;
    private final String language;
    private final String publisher;
    private final LocalDate registeredAt;
    private final boolean available;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.registeredAt = book.getRegisteredAt();
        this.available = book.isAvailable();
    }
}
