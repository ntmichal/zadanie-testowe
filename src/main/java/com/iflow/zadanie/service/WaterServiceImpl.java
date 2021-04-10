package com.iflow.zadanie.service;


import com.iflow.zadanie.algorithm.WaterAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class WaterServiceImpl implements WaterService{

    @Override
    public int getAmountOfWater(int[] array) {
        return WaterAlgorithm.calculateAmountOfWater(array);
    }
}
