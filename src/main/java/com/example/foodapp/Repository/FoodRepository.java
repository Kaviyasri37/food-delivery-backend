package com.example.foodapp.Repository;


import com.example.foodapp.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findByMoodType(String moodType);

    List<FoodItem> findByCategory(String category);
}