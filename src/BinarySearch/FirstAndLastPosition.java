package BinarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {4,4,5,5,5,9};
//        System.out.println(nums.length);
        int[] ans = findFirstAndLastPositionOfK(nums, 9);
        System.out.println(Arrays.toString(ans));
    }

    static int[] findFirstAndLastPositionOfK(int[] nums, int target){
        int[] ans = {-1,-1};
        int n = nums.length;

        int lb = findLowerBound(nums, target);
        if (lb == n || nums[lb] != target) return ans;
        int ub = findUpperBound(nums, target);
        ub-=1;

        ans[0] = lb;
        ans[1] = ub;
        return ans;
    }

    static int findLowerBound(int[] nums, int target){
        int n = nums.length;
        int low = 0; int high = n-1;
        int ans = n;
        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] >= target){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return ans;
    }

    static int findUpperBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        int ans = n;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] > target){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }
}
