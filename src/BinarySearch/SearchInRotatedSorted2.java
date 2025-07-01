package BinarySearch;

public class SearchInRotatedSorted2 {
    public static void main(String[] args) {
        int[] nums={1,0,1,1,1};
        int ans = test(nums, 0);
        System.out.println(ans);
    }

    static int test(int[] nums, int target){
        int n = nums.length;
        int low=0, high=n-1;

        while (low<=high){
            int mid = (low+high)/2;

            if (target == nums[mid]) return nums[mid];

            if (nums[low] == nums[mid] && nums[mid] == nums[high]){
                low +=1;
                high-=1;
                continue;
            }

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
