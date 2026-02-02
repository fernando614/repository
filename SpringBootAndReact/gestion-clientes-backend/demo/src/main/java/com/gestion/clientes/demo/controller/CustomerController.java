package com.gestion.clientes.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.clientes.demo.exception.ResourceNotFoundException;
import com.gestion.clientes.demo.model.Customer;
import com.gestion.clientes.demo.repository.CustomerRepository;
//esta notación crosorigin es lo que me va a permitir conectarme con mi backend
//desde react
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
//checar lo de requestMapping y api/v1 que significa v1
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    //método getMapping para obtener todos los clientes
    @GetMapping("/customers")
    public List<Customer> getListOfCustomers(){
        return customerRepository.findAll();
    }
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    //ahora obtener por id el número de cliente
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return ResponseEntity.ok(customer);
    }
    //ahora vamos a actualizar el cliente
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer requestCustomer){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        //seteo los valores al cliente encontrado y actualizado los valores
        customer.setName(requestCustomer.getName());
        customer.setSurname(requestCustomer.getSurname());
        customer.setEmail(requestCustomer.getEmail());

        return ResponseEntity.ok(customerRepository.save(customer));
    }
    //api para borrrar un cliente por id
    @DeleteMapping("customers/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        
        customerRepository.delete(customer);

        Map<String,Boolean>response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
        
    }
}
