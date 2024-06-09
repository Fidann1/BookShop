package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class RequestCustomer {
    private Long id;
    @NotNull(message="Name cannot be null")
    private String name;
    private String surname;
}
