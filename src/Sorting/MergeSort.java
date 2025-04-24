package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    /*
    This Algorithm is basically used because it has better time complexity, it takes O(NlogN)  time complexity
    Selection Sort, Bubble Sort, Insertion Sort are all O(n2)
    * */
    public static void main(String[] args) {
        int [] nums = {5, 4, 1, 2};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int [] nums, int start, int end){
        if (start >= end){
            return;
        }
        int mid = (start + end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int [] nums, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= end){
            if (nums[i] <= nums[j]){
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }

        while (i <= mid){
            temp.add(nums[i]);
            i++;
        }

        while (j <= end){
            temp.add(nums[j]);
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            nums[k+start] = temp.get(k);
        }
    }
}
