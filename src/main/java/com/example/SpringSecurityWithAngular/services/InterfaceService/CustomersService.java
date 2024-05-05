package com.example.SpringSecurityWithAngular.services.InterfaceService;

import com.example.SpringSecurityWithAngular.dto.CustomersDTO;
import com.example.SpringSecurityWithAngular.entities.Customers;

import java.util.List;

public interface CustomersService {
    Customers add(CustomersDTO customersDTO);
    List<CustomersDTO> getAll();
//    Page<Customers> getAll(Pageable pageable, String cin, String nom, String prenom, String adresse);
    CustomersDTO getById(long id);
    void update(long id,CustomersDTO customersDTO);
    void delete(long id);
}
