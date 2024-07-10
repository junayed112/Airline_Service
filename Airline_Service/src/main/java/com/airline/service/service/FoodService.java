package com.airline.service.service;

import com.airline.service.dto.FoodOrderRequestBody;
import com.airline.service.dto.FoodRequestBody;
import com.airline.service.model.Food;
import com.airline.service.repository.FoodRepository;
import com.airline.service.utils.SystemDateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food createFoodItem(FoodRequestBody requestBody) throws ParseException {
        Food foodItem = new Food();
        foodItem.setName(requestBody.getName());
        foodItem.setUnitPrice(requestBody.getUnitPrice());
        foodItem.setQuantity(requestBody.getQuantity());
        foodItem.setRemainingQuantity(requestBody.getQuantity());
//        foodItem.setPurchaseDate(SystemDateFormatter.setTicketPurchaseDate());

        return foodRepository.save(foodItem);
    }

    public Boolean orderFood(FoodOrderRequestBody requestBody) throws ParseException {
        Food existingFoodItem = foodRepository.findById(requestBody.getFoodItemId()).get();
        long remainingItem = existingFoodItem.getQuantity()- requestBody.getQuantity();
        if(remainingItem>0){
            BigDecimal totalAmount = existingFoodItem.getUnitPrice().multiply(BigDecimal.valueOf(requestBody.getQuantity()));
            existingFoodItem.setRemainingQuantity(remainingItem);
            existingFoodItem.setNumberOfOrders(requestBody.getQuantity());
            existingFoodItem.setTotalOrderAmount(totalAmount);
            existingFoodItem.setPurchaseDate(SystemDateFormatter.setTicketPurchaseDate());
            foodRepository.save(existingFoodItem);
            return true;
        }
        else{
            throw new RuntimeException("Not enough quantity available");
        }

    }

    public List<Food> getAll(){
        return foodRepository.findAll();
    }

    public Food getById(Long id){
        Food foodItem = foodRepository.findById(id).get();
        if(foodItem==null){
            throw new RuntimeException("FoodItem Not Found");
        }

        return foodItem;
    }
}
