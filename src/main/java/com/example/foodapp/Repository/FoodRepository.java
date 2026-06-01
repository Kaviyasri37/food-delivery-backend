package com.example.foodapp.Repository;


import com.example.foodapp.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findByMoodType(String moodType);

    List<FoodItem> findByCategory(String category);
}