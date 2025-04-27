package Recursion;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int [] nums = {4, 1, 5, 3, 2};
        recursiveBubbleSort(nums, nums.length - 1);
    }

    public static void recursiveBubbleSort(int [] nums, int n) {
        if (n == 0){
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = 0; i < n; i++){
            if (nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        recursiveBubbleSort(nums, n - 1);
    }
}
