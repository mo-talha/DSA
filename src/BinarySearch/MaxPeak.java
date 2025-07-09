package BinarySearch;

public class MaxPeak {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5};
////        int ans = findPeak(nums);
//        int ans = findPeakBrute(nums);
//        System.out.println(ans);
        System.out.println(3/2);
    }

//    Peak is a num which is > n-1 and n+1
    static int findPeak(int[] nums){
        int n = nums.length;
        int low = 0, high = n-1;

        if (n==1) return 0;

        while (low <= high){
            int mid = (low+high)/2;

            if (mid == 0 && nums[mid] > nums[mid+1] || mid == n-1 && nums[mid] > nums[mid]-1){
                return nums[mid];
            }
            else if (mid > 0 && nums[mid] > nums[mid-1] &&  nums[mid] > nums[mid+1]){
                return nums[mid];
            }
            else if (nums[mid] < nums[mid+1]){
                low=mid+1;
            }
            else {
                high=mid-1;
            }

        }
        return -1;
    }

    static int findPeakBrute(int[] nums){
        int n = nums.length;
        if (n==1) return 0;

        for (int i = 0; i < n; i++){
            if (i==0 && nums[i] > nums[i+1] || i == n-1 && nums[i] > nums[n-2]){
                return i;
            }
            if (i > 0 && nums[i] > nums[i+1] && nums[i] > nums[i-1]){
                return i;
            }
        }
        return -1;
    }
}
