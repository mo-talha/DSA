package Recursion;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int [] nums = {4, 1, 5, 2, 3};
        recursiveInsertionSort(nums, 0);
    }

    public static void recursiveInsertionSort(int [] nums, int i){
        if (i > nums.length - 1){
            System.out.println(Arrays.toString(nums));
            return;
        }
        int j = i;
        while (j > 0 && nums[j] < nums[j-1]){
            int temp = nums[j];
            nums[j] = nums[j-1];
            nums[j-1] = temp;

            j--;
        }
        recursiveInsertionSort(nums, i+1);
    }
}
