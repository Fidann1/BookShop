package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "genre_id")
    @SequenceGenerator(name ="genre_id",sequenceName = "genre_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Book> books;

}
