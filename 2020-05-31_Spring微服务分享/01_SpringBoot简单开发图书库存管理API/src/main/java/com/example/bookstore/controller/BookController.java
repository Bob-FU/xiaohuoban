package com.example.bookstore.controller;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.respository.BookRepository;
import com.example.bookstore.transaction.BookTransaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    private final BookTransaction bookTransaction;

    public BookController(BookRepository repository, BookTransaction bookTransaction){
        this.bookRepository = repository;
        this.bookTransaction = bookTransaction;
    }

    @GetMapping("/")
    List<BookEntity> getAllBooks(){
        return this.bookRepository.findAll();
    }

    @GetMapping("/{uuid}")
    BookEntity getOneBookByPk(@PathVariable("uuid") String uuid) {
        return this.bookRepository.getByBookid(uuid);
    }

    @GetMapping("/title/{title}")
    List<BookEntity> getManyByTitle(@PathVariable("title") String title) {
        return this.bookRepository.findByBooknameContaining(title);
    }

    @PutMapping("/")
    BookEntity updateBook(@RequestBody(required = true) BookEntity book){
        return this.bookRepository.save(book);
    }

    @PostMapping("/")
    BookEntity addBook(@RequestBody(required = true) BookEntity book){
        return this.bookRepository.save(book);
    }

    @PostMapping("/buy/{stock}")
    BookEntity buyBook(@RequestBody(required = true) BookEntity book, @PathVariable("stock") Integer stock){
        return this.bookTransaction.buyBook(book, stock);
    }

}
