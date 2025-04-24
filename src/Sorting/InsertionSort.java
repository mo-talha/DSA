package Sorting;

import Utils.Swap;

import java.util.Arrays;

public class InsertionSort {
/*
Insertion Sort - This technique focuses on comparing ith index with i-1 i.e. current index with previous index
if previous is greater than current then its positions are swapped.
* */
    public static void main(String[] args) {
        insertionSort();
    }

    public static void insertionSort(){
        int [] nums = {4, 1, 5, 2, 3};

        for (int i = 0; i < nums.length; i++){
            int j = i;

            while (j > 0 && nums[j] < nums[j-1]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;

                j--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
