package BinarySearch;

public class SearchInRotatedSorted1 {
    public static void main(String[] args) {
        int[] nums = {6,7,8,9,1,2,3,4,5};
        int ans = test(nums, 7);
        System.out.println(ans);
    }

    static int test(int[] nums, int target){
        int n = nums.length;
        int low=0, high=n-1;

        while (low<=high){
            int mid = (low+high)/2;

            if (target == nums[mid]) return nums[mid];

            if (nums[low] <= nums[mid]){
                if (nums[low] <= target && target < nums[mid]){
                    high = mid-1;
                } else {
                    low=mid+1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]){
                    low = mid+1;
                } else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
