package com.gestion.clientes.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.clientes.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
