package BinarySearch;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int ans = smallestDivisorOptimal(nums, 6);
        System.out.println(ans);
    }

    static int smallestDivisorOptimal(int[] nums, int threshold){
        int low = 1, high = findMax(nums);

        while(low <= high){
            int mid = (low+high)/2;

            if (isDivisor(nums, mid, threshold)){
                high = mid-1;
            } else{
                low = mid + 1;
            }
        }
        return low;
    }

    static int smallestDivisorBrute(int[] nums, int threshold){
        int n = nums.length;
        int min = findMin(nums), max = findMax(nums);
        for (int i = 1; i <= max; i++){
            if (isDivisor(nums, i, threshold)){
                return i;
            }
        }
        return -1;
    }

    static boolean isDivisor(int[] nums, int divisor, int threshold){
        int n = nums.length;
        int totalSum = 0;

        for (int num: nums){
            totalSum += Math.ceil((double) (num)/ (double) (divisor));
        }
        return totalSum <= threshold;
    }

    static int findMin(int[] nums){
        int min = Integer.MAX_VALUE;

        for (int num: nums){
            min = Math.min(min, num);
        }

        return min;
    }

    static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int num: nums){
            max = Math.max(max, num);
        }

        return max;
    }
}
