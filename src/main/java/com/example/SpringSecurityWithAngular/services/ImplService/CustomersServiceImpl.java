package com.example.SpringSecurityWithAngular.services.ImplService;


import com.example.SpringSecurityWithAngular.dto.CustomersDTO;
import com.example.SpringSecurityWithAngular.entities.Customers;
import com.example.SpringSecurityWithAngular.repositories.CustomersRepository;
import com.example.SpringSecurityWithAngular.services.InterfaceService.CustomersService;
import com.example.SpringSecurityWithAngular.utils.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {
    private final CustomersRepository repository;
    private final Mapper mapper;

    public CustomersServiceImpl(CustomersRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Customers add(CustomersDTO customersDTO) {
        return mapper.map(repository.save(mapper.map(customersDTO, Customers.class)),Customers.class);
    }

    @Override
    public List<CustomersDTO> getAll() {
        return mapper.mapList(repository.findAll(),CustomersDTO.class);
    }

    @Override
    public CustomersDTO getById(long id) {
        Customers customers=repository.findById(id).get();
        return mapper.map(customers,CustomersDTO.class);
    }

    @Override
    public void update(long id, CustomersDTO customersDTO) {
        Optional<Customers> customers=repository.findById(id);
        if(customers.isPresent()){
            Customers customers1=customers.get();
            customers1.setName(customersDTO.getName());
            customers1.setEmail(customersDTO.getEmail());
            repository.save(customers1);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Customers> customers=repository.findById(id);
        if(customers.isPresent()){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("conducteur avec l'ID"+id+"n'a pas trouvee");
        }
    }
}
