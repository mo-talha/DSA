package Sorting;

import Utils.Swap;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] nums = {4, 1, 5, 3, 2};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int [] nums, int start, int end){
        if (start < end){
            int pivot = getPivot(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot+1, end);
        }
    }

    static int getPivot(int [] nums, int start, int end){
        int pivot = nums[start];
        int i = start;
        int j = end;

        while (i < j){
            while (nums[i] <= pivot && i <= end){
                i++;
            }
            while (nums[j] > pivot && j >= start){
                j--;
            }
            if (i < j){
                Swap.swap(nums, i, j);
            }
        }
        Swap.swap(nums, start, j);
        return j;
    }
}
