package BinarySearch;

public class MinDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,12,7,7};
//        int ans = bruteForce(nums, 3, 1);
        int ans = optimised(nums, 2, 3);
        System.out.println(ans);
    }

    static int bruteForce(int[] nums, int m, int k){
        int min = findMin(nums);
        int max = findMax(nums);
        for (int i = min; i <= max; i++){
            if (isPossible(nums, i, m, k)){
                return i;
            }
        }
        return -1;
    }

    static int optimised(int[] nums, int m, int k){
        int low = findMin(nums), high = findMax(nums);
        int ans = -1;
        while (low<=high){
            int mid = (low+high)/2;

            if (isPossible(nums, mid, m, k)){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }

    static Boolean isPossible(int[] nums, int day, int m, int k){
        int n = nums.length;
        int count = 0;
        int noOfBouquets = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] <= day){
                count+=1;
            } else {
                noOfBouquets += (count/k);
                count=0;
            }
        }
        noOfBouquets += (count/k);
        return noOfBouquets >= m;
    }

    static int findMax(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            max = Math.max(nums[i], max);
        }

        return max;
    }

    static int findMin(int[] nums){
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            min = Math.min(nums[i], min);
        }

        return min;
    }
}
