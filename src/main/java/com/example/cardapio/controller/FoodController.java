package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.service.FoodService;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    FoodService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Food>> getAll() {
        return new ResponseEntity<>(this.service.getAllFood(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.service.getFoodById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity<Object> addFood(@RequestBody FoodRequestDTO payload) {
        this.service.addFood(payload);
        return new ResponseEntity<>("Produto criado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateFood(@PathVariable("id") String id, @RequestBody FoodRequestDTO payload) {
        this.service.updateFood(id, payload);
        return new ResponseEntity<Object>("Produto" + " " + id + " " + "atualizado", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteFood(@PathVariable("id") String id) {
        this.service.deleteFood(id);
        return new ResponseEntity<Object>("Produto" + " " + id + " " + "deletado com sucesso", HttpStatus.OK);
    }

}
