package com.school.library.service;

import com.school.library.entity.Book;
import com.school.library.entity.Member;
import com.school.library.model.request.BookRq;
import com.school.library.model.response.BookRs;
import com.school.library.model.response.MemberRs;
import com.school.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public BookRs createBook(BookRq bookRq){
        validationService.validate(bookRq);

        if(bookRepository.existsByName(bookRq.getName())){
            throw new RuntimeException("Book already exists");
        }

        Book book = new Book();
        book.setName(bookRq.getName());
        book.setAuthor(bookRq.getAuthor());
        book.setPublisher(bookRq.getPublisher());
        book.setNumberOfPage(bookRq.getNumberOfPage());
        book.setDateOfEntry(new Date());

        bookRepository.save(book);
        return toBookRs(book);
    }

    public BookRs toBookRs(Book book){
        return BookRs.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .numberOfPage(String.valueOf(book.getNumberOfPage()))
                .dateOfEntry(String.valueOf(book.getDateOfEntry()))
                .build();
    }

    @Transactional
    public BookRs get(Long bookId){
        Book book = bookRepository.findById(String.valueOf(bookId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return toBookRs(book);
    }

    @Transactional
    public BookRs update(Long bookId, BookRq bookRq){
        validationService.validate(bookRq);

        Book book = bookRepository.findById(String.valueOf(bookId)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        book.setName(bookRq.getName());
        book.setAuthor(bookRq.getAuthor());
        book.setPublisher(bookRq.getPublisher());
        book.setNumberOfPage(bookRq.getNumberOfPage());

        bookRepository.save(book);
        return toBookRs(book);
    }
}
