package com.osiki.BookApplication.service;

import com.osiki.BookApplication.dto.BookDto;
import com.osiki.BookApplication.model.Book;

import java.util.List;

public interface BookService {

    BookDto createBook(Long id, BookDto bookDto);

    BookDto getBookById(Long id);

    List<BookDto> getAllBooksByUserId(Long userId);

    BookDto updateBook(Long id, BookDto bookDto);

    boolean deleteBook(Long id);

}
