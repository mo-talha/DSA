package BinarySearch;

public class MinInRotatedSortedArr {
    public static void main(String[] args) {
        int[] nums = {6,0,1,2,3,4,5};
        int ans = minInRotatedSortedArray(nums);
        System.out.println(ans);
    }

    static int minInRotatedSortedArray(int[] nums){
        int n = nums.length;
        int low = 0, high = n-1;
        int min=Integer.MAX_VALUE;

        while (low<=high){
            int mid = (low+high)/2;

            if (nums[low] <= nums[high]){
                min = Math.min(min, nums[low]);
                low=mid+1;
            } else {
                min = Math.min(min, nums[mid]);
                high=mid-1;
            }
        }
        return min;
    }
}
