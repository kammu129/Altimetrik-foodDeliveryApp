package com.altimetrik.foodfanda.entity;

import com.altimetrik.foodfanda.support.Rating;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@Data
@Builder(toBuilder = true)
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESTAURANT_ID")
    private UUID uuid;
    private String name;
    @Enumerated(EnumType.STRING)
    private Rating rating;
    @ManyToMany
    @JoinTable(
            name = "RESTAURANT_RECIPIES",
            joinColumns = @JoinColumn(name = "RESTAURANT_ID"),
            inverseJoinColumns = @JoinColumn(name = "RECIPE_ID")
    )
    private List<Recipe> recipes;
    @OneToOne
    @JoinColumn(name = "location")
    private Address location;
}
