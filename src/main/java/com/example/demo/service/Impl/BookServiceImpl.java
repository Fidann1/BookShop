package com.example.demo.service.Impl;

import com.example.demo.dto.RequestBook;
import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {
    BookRepository bookRepository;
    CustomerRepository customerRepository;;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository,CustomerRepository CustomerRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = CustomerRepository;
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public void saveBook(Long id,RequestBook book) {
        Customer customer=customerRepository.findById(id).orElseThrow();
        Book book1=Book.builder().title(book.getTitle()).id(book.getId()).customerList(new ArrayList<>()).build();

        customer.getBooks().add(book1);
        book1.getCustomerList().add(customer);



        bookRepository.save(book1);
        System.out.println("Operation is done successfully.");

    }
}
