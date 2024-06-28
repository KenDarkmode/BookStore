package com.example.Bookstore.repository;

import com.example.Bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
