package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="author_id")
    @SequenceGenerator(name="author_id",sequenceName = "author_id")
    private Long id;

    private String name;

    private BigDecimal payment;

    @OneToMany(mappedBy = "author")

    private List<Book> books;

}
