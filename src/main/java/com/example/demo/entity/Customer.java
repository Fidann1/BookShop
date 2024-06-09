package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_id")
    @SequenceGenerator(name ="customer_id",sequenceName = "customer_id")
    private Long id;
    @NotBlank(message= "Name can't be null")


    private String name;
    private String surname;

    @ManyToMany()
    @JsonManagedReference
    @JoinTable(name = "liked_books",
    joinColumns=  @JoinColumn(name="customer_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )

    private List<Book> books;
}
