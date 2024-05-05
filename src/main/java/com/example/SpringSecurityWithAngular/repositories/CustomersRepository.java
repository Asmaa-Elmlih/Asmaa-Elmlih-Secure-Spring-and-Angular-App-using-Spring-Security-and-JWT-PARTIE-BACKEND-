package com.example.SpringSecurityWithAngular.repositories;

import com.example.SpringSecurityWithAngular.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Long> {
}
