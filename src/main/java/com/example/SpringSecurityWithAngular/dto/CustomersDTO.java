package com.example.SpringSecurityWithAngular.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {
    private Long id;
    private String name;
    private String email;
}
