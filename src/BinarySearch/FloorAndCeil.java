package BinarySearch;

import java.util.Arrays;

public class FloorAndCeil {
    public static void main(String[] args) {
        int[] nums={3,4,4,7,8,10};
        int[] ans = floorCiel(nums, 7);
        System.out.println(Arrays.toString(ans));
    }

    static int[] floorCiel(int[] nums, int target){
        int[] ans=new int[2];
        int floor=floor(nums,target);
        int ceil=ceil(nums,target);
        ans[0]=floor;
        ans[1]=ceil;
        return ans;
    }

//    Floor is the greatest num <= target.
    static int floor(int[] nums, int target){
        int n=nums.length;
        int low=0, high=n-1;
        int floor=-1;
        while (low <= high){
            int mid=(low+high)/2;

            if (nums[mid] <= target){
                floor= nums[mid];
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return floor;
    }

    //    Ceil is the smallest num >= target.
    static int ceil(int[] nums, int target){
        int n=nums.length;
        int low=0, high=n-1;
        int ceil=-1;
        while (low <= high){
            int mid=(low+high)/2;

            if (nums[mid] >= target){
                ceil= nums[mid];
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ceil;
    }
}
