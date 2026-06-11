package com.example.foodapp.Controller;

import com.example.foodapp.Entity.FoodItem;
import com.example.foodapp.Repository.FoodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "*")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping("/count")
    public long countFoods() {
        return foodRepository.count();
    }
    @GetMapping
    public List<FoodItem> getAllFoods() {
        return foodRepository.findAll();
    }

    @PostMapping
    public FoodItem addFood(@RequestBody FoodItem foodItem) {
        return foodRepository.save(foodItem);
    }

    @GetMapping("/{id}")
    public FoodItem getFoodById(@PathVariable Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
        return "Food deleted successfully";
    }

    @GetMapping("/category/{category}")
    public List<FoodItem> getFoodsByCategory(@PathVariable String category) {
        return foodRepository.findByCategory(category);
    }

    @GetMapping("/recommend/{mood}")
    public List<FoodItem> recommendFoods(@PathVariable String mood) {
        return foodRepository.findByMoodType(mood);
    }

}
