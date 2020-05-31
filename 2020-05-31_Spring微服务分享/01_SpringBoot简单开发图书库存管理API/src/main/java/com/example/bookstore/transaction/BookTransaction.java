package com.example.bookstore.transaction;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.respository.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookTransaction {

    private final BookRepository bookRepository;

    public BookTransaction (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = false)
    public BookEntity buyBook(BookEntity book, Integer volume)
    {
        BookEntity bookEntity = bookRepository.findByBookid(book.getBookid());
        if (bookEntity == null || (bookEntity!=null && bookEntity.getStock() - volume < 1)){
            return null;
        }
        bookEntity.setStock(bookEntity.getStock()-volume);
        bookRepository.save(bookEntity);
        return bookEntity;
    }
}
