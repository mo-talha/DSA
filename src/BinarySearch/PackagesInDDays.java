package BinarySearch;

public class PackagesInDDays {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
//        Boolean ans = isPossible(nums, 5, 15);
//        int ans = shipWithinDaysBrute(nums, 5);
        int ans = shipWithinDaysOptimal(nums, 5);
        System.out.println(ans);
    }

    static int shipWithinDaysOptimal(int[] weights, int days){
        int low = findMaxWeight(weights), high = sumOfAllWeights(weights);

        while (low <= high){
            int mid = (low + high)/2;

            if (isPossible(weights, days, mid)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
         return low;
    }

    static int shipWithinDaysBrute(int[] weights, int days){
        int min = findMaxWeight(weights), max = sumOfAllWeights(weights);

        for (int i = min; i <= max; i++){
            if (isPossible(weights, days, i)){
                return i;
            }
        }
        return -1;
    }

    static boolean isPossible(int[] nums, int d, int capacity){
        int n = nums.length;
        int load = 0;

        int noOfDays = 1;
        for (int i = 0; i < n; i++){
            if (load + nums[i] > capacity){
                noOfDays += 1;
                load = nums[i];
            } else {
                load += nums[i];
            }
        }
        return noOfDays <= d;
    }

    static int findMaxWeight(int[] weights){
        int max = Integer.MIN_VALUE;

        for (int wt: weights){
            max = Math.max(wt, max);
        }
        return max;
    }

    static int sumOfAllWeights(int[] weights){
        int sum = 0;
        for (int wt: weights){
            sum+=wt;
        }
        return sum;
    }
}
