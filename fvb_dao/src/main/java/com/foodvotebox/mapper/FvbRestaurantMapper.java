package com.foodvotebox.mapper;

import com.foodvotebox.pojo.FvbRestaurant;

/**
 * Created by FYG on 17/6/25.
 */
public interface FvbRestaurantMapper {
    FvbRestaurant queryByName(String RestaurantName);
}