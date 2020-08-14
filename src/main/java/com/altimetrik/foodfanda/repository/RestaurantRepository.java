package com.altimetrik.foodfanda.repository;

import com.altimetrik.foodfanda.entity.Restaurant;
import com.altimetrik.foodfanda.support.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, UUID> {
    List<Restaurant> findByRating(Rating rating);
}
