package com.osiki.BookApplication.repository;

import com.osiki.BookApplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByUserId(Long userId);
}
