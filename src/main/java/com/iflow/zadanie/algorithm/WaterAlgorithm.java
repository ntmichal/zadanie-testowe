package com.iflow.zadanie.algorithm;

import com.iflow.zadanie.exceptions.ArrayIsEmptyException;

public class WaterAlgorithm {

    public static int calculateAmountOfWater(int[] array){
        checkArrayIsNull(array);
        checkArrayLengh(array);

        int result = 0;

        int startIndex = 0;
        int endIndex = array.length -1;
        while (startIndex < endIndex) {
            if(array[startIndex] < array[endIndex]){

                if(array[startIndex] > array[startIndex+1]){
                    result += array[startIndex] - array[startIndex+1];
                    array[startIndex+1] = array[startIndex];
                }

                startIndex++;
            }else{

                if(array[endIndex-1] < array[endIndex]){
                    result += array[endIndex] - array[endIndex-1];
                    array[endIndex-1] = array[endIndex];
                }

                endIndex--;
            }
        }
        return result;

    }

    private static void checkArrayIsNull(int[] array){
        if(array == null){
            throw new NullPointerException();
        }
    }
    private static void checkArrayLengh(int[] array){
        if(array.length == 0){
            throw new ArrayIsEmptyException();
        }
    }
}
