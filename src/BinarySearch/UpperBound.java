package BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class UpperBound {
    public static void main(String[] args) {
//        int[] nums={1,2,3,3,7,8,9,9,9,11};
//        int ans = upperBound(nums, 7);
//        System.out.println(ans);

    }
//    Smallest index at which the num is > than the target

    public static int upperBound(int[] nums, int target){
        int n = nums.length;
        int low=0, high=n-1;
        int ans=n;
        while (low<=high){
            int mid = (low+high)/2;

            if (nums[mid]>target){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }


}
