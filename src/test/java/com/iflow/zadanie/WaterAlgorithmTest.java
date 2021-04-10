package com.iflow.zadanie;

import com.iflow.zadanie.algorithm.WaterAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WaterAlgorithmTest {

    @Test
    void sameValues(){
        int[] input = new int[]{0, 0};

        assertEquals(0, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void valuesWithoutLocalMinimum(){
        int[] input = new int[]{1, 2, 1};

        assertEquals(0, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void twoValuesFirstValueLowerThanSecond(){
        int[] input = new int[]{0, 9};

        assertEquals(0, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void twoValuesFirstValueHigherThanSecond(){
        int[] input = new int[]{9, 0};

        assertEquals(0, WaterAlgorithm.calculateAmountOfWater(input));
    }
    @Test
    void oneValue(){
        int[] input = new int[]{0};

        assertEquals(0, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void oneValueNegative(){
        int[] input = new int[]{-1};

        assertEquals(0, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void twoLocalMin(){
        int[] input = new int[]{1, 2, 0, 4, 3,1,2};


        assertEquals(3, WaterAlgorithm.calculateAmountOfWater(input));
    }
    @Test
    void oneLocalMin(){
        int[] input = new int[]{1,2, 0, 1, 3, 1};

        assertEquals(3, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void oneLocalMin_1(){
        int[] input = new int[]{5,0, 5};

        assertEquals(5, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void test1(){
        int[] input = new int[]{1,5, 1, 2, 1, 5,1};

        assertEquals(11, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void test2(){
        int[] input = new int[]{1, 2, 0, 1, 4, 3, 1, 2, 5, 1};

        assertEquals(9, WaterAlgorithm.calculateAmountOfWater(input));
    }

    @Test
    void test3(){
        int[] input = new int[]{1, 9, 1, 0, 4, 7};

        assertEquals(16, WaterAlgorithm.calculateAmountOfWater(input));
    }


}