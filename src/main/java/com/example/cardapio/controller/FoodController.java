package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Food;
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

    // @CrossOrigin(origins = "*", allowedHeaders = "*")
    // @PostMapping
    // public void saveFood(@RequestBody FoodRequestDTO data) {
    // Food foodData = new Food(data);
    // repository.save(foodData);
    // return;
    // }
}
