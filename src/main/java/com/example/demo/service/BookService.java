package com.example.demo.service;

import com.example.demo.dto.RequestBook;
import com.example.demo.dto.RequestCustomer;
import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getBookList();
    public Optional<Book> getBookById(Long id);
    public void saveBook(Long id,RequestBook book);

}
