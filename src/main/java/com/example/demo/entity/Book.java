package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_id")
    @SequenceGenerator(name ="book_id",sequenceName = "book_id")
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;

    @ManyToMany
    @JsonBackReference
            @JoinTable(name="customers_books",
            joinColumns=@JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    List<Customer> customerList;

    public Book(){
        this.customerList = new ArrayList<>();
    }



}
