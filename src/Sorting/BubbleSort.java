package Sorting;

import Utils.Swap;

import java.util.Arrays;

public class BubbleSort {
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
