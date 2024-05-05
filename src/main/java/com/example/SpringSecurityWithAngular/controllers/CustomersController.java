package com.example.SpringSecurityWithAngular.controllers;


import com.example.SpringSecurityWithAngular.dto.CustomersDTO;
import com.example.SpringSecurityWithAngular.services.ImplService.CustomersServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomersController {
    private final CustomersServiceImpl service;

    public CustomersController(CustomersServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<List<CustomersDTO>> getAll(){
        List<CustomersDTO> customersDTOS=service.getAll();
        return new ResponseEntity<>(customersDTOS, HttpStatus.OK);
    }
    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> Create(@RequestBody CustomersDTO customersDTO){
        service.add(customersDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<CustomersDTO> getById(@PathVariable Long id) {
        CustomersDTO agentDTO = service.getById(id);
        return new ResponseEntity<>(agentDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody CustomersDTO agentDTO){
        CustomersDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.update(id,agentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        CustomersDTO agentDTO1=service.getById(id);
        if(!id.equals(agentDTO1.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
