package com.osiki.BookApplication.service.impl;

import com.osiki.BookApplication.dto.BookDto;
import com.osiki.BookApplication.exceptions.BookNotFoundException;
import com.osiki.BookApplication.exceptions.UserNotFoundException;
import com.osiki.BookApplication.model.Book;
import com.osiki.BookApplication.model.User;
import com.osiki.BookApplication.repository.BookRepository;
import com.osiki.BookApplication.repository.UserRepository;
import com.osiki.BookApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;


    @Override
    public BookDto createBook(Long id, BookDto bookDto) {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User does not exists"));

        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .pages(bookDto.getPages())
                .bookStatus(bookDto.getBookStatus())
                .user(user)
                .build();

        bookRepository.save(book);

        return bookDto;
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book Not Found"));

        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);

        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooksByUserId(Long userId) {
        List<Book> books = bookRepository.findAllByUserId(userId);
        return convertToDoList(books);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book Not Found"));

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPages(bookDto.getPages());
        book.setBookStatus(bookDto.getBookStatus());

        bookRepository.save(book);

        return bookDto;
    }

    @Override
    public boolean deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book Not Found"));

        bookRepository.delete(book);

        return true;
    }

    private List<BookDto> convertToDoList(List<Book> books) {
        List<BookDto> dtoList = new ArrayList<>();

        for(Book book : books){
            BookDto dto = new BookDto();

            dto.setTitle(book.getTitle());
            dto.setAuthor(book.getAuthor());
            dto.setPages(book.getPages());
            dto.setBookStatus(book.getBookStatus());

            dtoList.add(dto);
        }

        return dtoList;
    }

}
