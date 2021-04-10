package com.iflow.zadanie.controller;


import com.iflow.zadanie.service.WaterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/water")
public class WaterController {

    private WaterService waterService;

    public WaterController(WaterService waterService){
        this.waterService = waterService;
    }

    @PostMapping
    public int calculateAmountOfWater(@RequestBody int[] arrayBeforeRainFall){
        return  waterService.getAmountOfWater(arrayBeforeRainFall);

    }


}
