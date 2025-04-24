package Sorting;

import Utils.Swap;

import java.util.Arrays;

public class BubbleSort {
/*
Bubble Sort - This technique focuses on putting the largest elem of a sub-array on the last index
- Iterate from o - n.len
- Inner loop - Iterate from 0 - n.len - i - 0 (This formula will keep decreasing the end of the array)
- Compare if j > j+1 if yes swap
* */
    public static void main(String[] args) {
        bubbleSort2();
    }

    public static void bubbleSort2(){
        int [] nums = {4, 1, 5, 2, 3};

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - i - 1; j++){
                if (nums[j] > nums[j+1]){
                    Swap.swap(nums, j, j+1);
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
