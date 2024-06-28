package com.example.Bookstore.controller;

import com.example.Bookstore.entity.Book;
import com.example.Bookstore.services.BookServices;
import com.example.Bookstore.services.CategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookServices bookService;

    @Autowired
    private CategoryServices categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getALlBooks();
        model.addAttribute("books", books);
        return "templates/templates/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("templates/templates", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "templates/templates/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("templates/templates") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "templates/templates/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            model.addAttribute("templates/templates", book);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "templates/templates/edit";
        }
        return "redirect:/books";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("templates/templates") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "templates/templates/edit";
        }
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
