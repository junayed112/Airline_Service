package com.airline.service.controller;

import com.airline.service.base.BaseResponse;
import com.airline.service.dto.FoodOrderRequestBody;
import com.airline.service.dto.FoodRequestBody;
import com.airline.service.model.Food;
import com.airline.service.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("")
    public BaseResponse getInfoById(@RequestParam Long itemId){
        Food food = foodService.getById(itemId);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
                .setData(food);
    }

    @PostMapping("/create")
    public BaseResponse createNewFoodItem(@RequestBody FoodRequestBody requestBody) throws ParseException {
        Food foodItem = foodService.createFoodItem(requestBody);
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully Created")
                .setData(foodItem);
    }

    @PostMapping("/order")
    public BaseResponse orderFoodItem(@RequestBody FoodOrderRequestBody requestBody) throws ParseException {
        Boolean response = foodService.orderFood(requestBody);
        return new BaseResponse<>(200, "Order Placed successfully", response);
    }

    @GetMapping("/all")
    public BaseResponse getAll(){
        List<Food> foodList = foodService.getAll();
        return new BaseResponse<>().setStatusCode(200).setMessage("Successfully retrieved")
                .setData(foodList);
    }
}
