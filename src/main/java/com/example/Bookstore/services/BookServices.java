package com.example.Bookstore.services;

import com.example.Bookstore.entity.Book;
import com.example.Bookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getALlBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
