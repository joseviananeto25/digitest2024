package com.example;

import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Pizza;
import com.example.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





/**
 * This task expects you to create an implementation of a REST API Server.
 * Your code should expose a REST API. 
 * Feel free to explore possibilities/functionalities/capabilities following Rest standard (best practices) 
 * and any framework or library to help you in this journey.
 * We suggest that your implementation have at least a CRUD scenario about any subject.
 * Be creative!
 *
 */
@RestController
@RequestMapping("/pizza")
public class RESTAPIServerTask {

    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping("/")
    public Iterable<Pizza> listarTodas() {
        return pizzaRepository.findAll();
    }

    @PostMapping("/")
    public Pizza criar(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @PutMapping("/{id}/")
    public Pizza alterar(@PathVariable("id") Long id, @RequestBody Pizza pizza) {

        System.out.println(id);
        Pizza pizzaNew = pizzaRepository.findById(id).get();
        
        pizzaNew.setNome(pizza.getNome());
        pizzaNew.setDescricao(pizza.getDescricao());
        
        return pizzaRepository.save(pizzaNew);
    }

    @DeleteMapping("/{id}/")
    public void deletar(@PathVariable("id") Long id) {
        pizzaRepository.deleteById(id);
    }
    
    
    

}