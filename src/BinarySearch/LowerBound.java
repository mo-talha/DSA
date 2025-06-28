package BinarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums={1,2,3,5};
        int ans = lowerBound(nums, 4);
        System.out.println(ans);
    }

//    Lower bound is the smallest index at which the num is >= to x/target

    static int lowerBound(int[] nums, int target){
        int n = nums.length;
        int low=0, high=n-1;
        int ans=n;
        while (low<=high){
            int mid=(low+high)/2;

            if (nums[mid] >= target){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }
}
