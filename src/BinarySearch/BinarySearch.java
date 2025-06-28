package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int ans = binarySearch(nums,5);
        System.out.println(ans);
    }

    static int binarySearch(int[] nums, int target){
        int low=0, high=nums.length-1;

        while (low <= high){
            int mid = (low+high)/2;

            if (target == nums[mid]){
                return nums[mid];
            }

            if (target < nums[mid]){
                high = mid-1;
            }

            if (target > nums[mid]){
                low = mid+1;
            }
        }

        return -1;
    }
}
