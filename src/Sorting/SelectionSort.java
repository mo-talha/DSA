package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        selectionSort();
    }

    public static void selectionSort(){
        int [] nums = {3, 1, 5, 4};

        for (int i = 0; i < nums.length; i++){
            int min = i;
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] < nums[i]){
                    min = j;
                }
            }
            swap(nums, i, min);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int [] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
