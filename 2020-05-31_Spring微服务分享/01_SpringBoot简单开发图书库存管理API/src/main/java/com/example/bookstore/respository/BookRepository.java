package com.example.bookstore.respository;

import com.example.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, String> {

    List<BookEntity> findAll();

    BookEntity getByBookid(String uuid);

    List<BookEntity> findByBooknameContaining(String name);

    @Lock(LockModeType.PESSIMISTIC_READ)
    BookEntity findByBookid(String uuid);

}
