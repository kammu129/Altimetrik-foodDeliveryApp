package com.altimetrik.foodfanda.controller;

import com.altimetrik.foodfanda.entity.Restaurant;
import com.altimetrik.foodfanda.service.RestaurantService;
import com.altimetrik.foodfanda.support.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Restaurant>> findAll(){
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}/rating")
    public ResponseEntity<List<Restaurant>> findByRating(@PathVariable Integer id){
        return new ResponseEntity<>(restaurantService.findByRating(Rating.fromInteger(id)), HttpStatus.OK);
    }
}
