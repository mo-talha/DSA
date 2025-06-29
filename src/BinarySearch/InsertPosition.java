package BinarySearch;

public class InsertPosition {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int ans = insertPosition(nums,2);
        System.out.println(ans);
    }

    static int insertPosition(int[] nums, int target){
        int n = nums.length;
        int low=0, high=n-1;

        while (low<=high){
            int mid=(low+high)/2;

            if (target == nums[mid]) return mid;

            if (target < nums[mid]){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return low;
    }
}
