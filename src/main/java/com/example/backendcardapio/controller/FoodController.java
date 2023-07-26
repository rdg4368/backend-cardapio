package com.example.backendcardapio.controller;


import com.example.backendcardapio.food.Food;
import com.example.backendcardapio.food.FoodRepository;
import com.example.backendcardapio.food.FoodRequestDTO;
import com.example.backendcardapio.food.FoodResponseDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")

public class FoodController {

    @Autowired
    private FoodRepository repository;


    @CrossOrigin(origins = "*", allowCredentials = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }
    @CrossOrigin(origins = "*", allowCredentials = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
