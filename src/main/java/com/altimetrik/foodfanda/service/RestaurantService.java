package com.altimetrik.foodfanda.service;

import com.altimetrik.foodfanda.entity.Restaurant;
import com.altimetrik.foodfanda.repository.RestaurantRepository;
import com.altimetrik.foodfanda.support.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll() {
        List<Restaurant> restaurants=new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    public Restaurant findById(UUID id){
        final Optional<Restaurant> byId = restaurantRepository.findById(id);
        return byId.orElseThrow(()->new RuntimeException("Restaurant Not Found"));
    }

    public List<Restaurant> findByRating(Rating rating){
        return restaurantRepository.findByRating(rating);
    }
}
