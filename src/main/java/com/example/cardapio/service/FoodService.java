package com.example.cardapio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.foodRepository;

@Service
public class FoodService {

    @Autowired
    foodRepository repository;

    public List<Food> getAllFood() {
        List<Food> foodList = repository.findAll();
        return foodList;
    }

    public Food getFoodById(String id) {
        Food food = repository.findById(id).get();
        return food;
    }

    public void addFood(FoodRequestDTO payload) {
        var newFood = new Food(payload);
        repository.save(newFood);
    }

    public void updateFood(String id, FoodRequestDTO body) {
        Food food = repository.findById(id).get();
        food.setImage(body.image());
        food.setPrice(body.price());
        food.setImage(body.image());

        repository.save(food);
    }

    public void deleteFood(String id) {
        repository.deleteById(id);
    }
}
