package com.example.springlv2.repository;

import com.example.springlv2.entity.book.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByOrderByRegisteredAtAsc();

}
