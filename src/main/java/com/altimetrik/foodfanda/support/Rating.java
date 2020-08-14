package com.altimetrik.foodfanda.support;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Rating {
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5);
    @JsonValue
    private final Integer rating;

    private static final Map<Integer,Rating> RATING_MAP= Arrays.stream(values())
            .collect(Collectors.toMap(Rating::getRating, Function.identity()));

    public static Rating fromInteger(Integer ratingId){
        return RATING_MAP.getOrDefault(ratingId,null);
    }

}
