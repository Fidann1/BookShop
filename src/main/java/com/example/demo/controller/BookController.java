package com.example.demo.controller;

import com.example.demo.dto.RequestBook;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/book")

public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping(path="list")
    public List<Book> list() {
        return bookService.getBookList();
    }
    @GetMapping(path="id/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.getBookById(id).get();
    }

    @PostMapping(path="save/{id}")
    public void save(@RequestBody RequestBook requestBook,@PathVariable Long id) {
        bookService.saveBook(id,requestBook);
    }

}
