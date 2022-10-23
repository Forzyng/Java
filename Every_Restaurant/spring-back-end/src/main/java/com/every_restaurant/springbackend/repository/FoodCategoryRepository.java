package com.every_restaurant.springbackend.repository;

import com.every_restaurant.springbackend.model.FoodCategory;
import com.every_restaurant.springbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
    Optional<FoodCategory> findByName(String name);
}
