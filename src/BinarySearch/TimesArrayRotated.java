package BinarySearch;

import java.util.Scanner;

public class TimesArrayRotated {
    public static void main(String[] args) {
//        int[] nums = {6,7,8,0,1,2,3,4,5};
//        int[] nums={4, 5, 1, 2, 3};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] nums = {1,2,3,4,5};
        int ans = timesArrayRotated(nums);
//        int ans = timesArrayRotatedBrute(nums);
//        int ans = timesArrayRotatedBrute(nums);
        System.out.println(ans);
//        System.out.println(7/2);
    }

    static int timesArrayRotated(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1, index=-1, ans=Integer.MAX_VALUE;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[low] <= nums[mid]){
                if (nums[low] < ans){
                    ans=nums[low];
                    index=low;
                }
                low = mid+1;
            } else {
                if (nums[mid] < ans){
                    ans=nums[mid];
                    index=mid;
                }
                high = mid-1;
            }
        }
        return index;
    }

    static int timesArrayRotatedBrute(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count += 1;
            } else {
                break;
            }
        }
        return count + 1;
    }

    static int timesArrayRotatedBrute2(int[] nums) {
        int n = nums.length;
        int rotations = 0, ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] < ans) {
                ans = nums[i];
                rotations = i;
            }
        }
        return rotations;
    }
}
