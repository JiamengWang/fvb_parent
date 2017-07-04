package com.foodvotebox.controller;

import com.FoodVoteBox.exception.AddAsFavouriteEnum;
import com.foodvotebox.pojo.FvbRestaurant;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.AddRestaurantAsFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by qianle on 7/4/17.
 */

@Service
@RequestMapping("/")
public class AddAsFavouriteController {

    @Autowired
    public AddRestaurantAsFavouriteService addRestaurantAsFavouriteService;

    @RequestMapping("/addasfavourite")
    @ResponseBody
    public String addAsFavourite(FvbRestaurant restaurant, HttpSession session) {
        //FvbRestaurant restaurant = new FvbRestaurant();
        //restaurant.setRestaurantName("heqianledajiudian");
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        AddAsFavouriteEnum e = addRestaurantAsFavouriteService.addRestaurantAsFavouriteService(user.getUserId(), restaurant);
        System.out.println(e.getStateinfo());
        return e.getStateinfo();
    }

    @RequestMapping("/cancelfavourite")
    @ResponseBody
    public String cancelFavourite(FvbRestaurant restaurant, HttpSession session) {
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        AddAsFavouriteEnum e = addRestaurantAsFavouriteService.removeFavouriteRestaurant(user.getUserId(), restaurant.getRestaurantId());
        return e.getStateinfo();
    }
}
