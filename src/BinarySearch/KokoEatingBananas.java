package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] nums = {3, 6, 7, 11};
//        int ans = findMax(nums);
//        System.out.println(ans);
        int ans = kokoEatingBananas(nums, 8);
        System.out.println(ans);
    }

    static int kokoEatingBananas(int[] nums, int hours){
        int n = nums.length;
        int ans = n;
        int low = 1, high = findMax(nums);

        while (low <= high){
            int mid = (low+high)/2;
            int totalHrs = totalHours(nums, mid);

//            if (totalHrs == hours){
//                return mid;
//            }
            if (totalHrs <= hours){
                ans=mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    static int totalHours(int[] nums, int hours){
        int totalHrs = 0;

        for (int num : nums) {
            totalHrs += ceilValue(num, hours);
        }
        return totalHrs;
    }

    static int findMax(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    static int ceilValue(int a, int b){
        return (a+b-1)/b;
    }
}
