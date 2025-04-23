package Sorting;

import Utils.Swap;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
//        bubbleSort();
        bubbleSort2();
    }

    public static void bubbleSort(){
//        int [] nums = {2, 1, 3, 5, 4};
        int [] nums = {4, 1, 5, 2, 3};
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]){
                Swap.swap(nums, i, i-1);
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort2(){
        int [] nums = {4, 1, 5, 2, 3};

        for (int i = nums.length - 1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[j+1]){
                    Swap.swap(nums, j, j+1);
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
