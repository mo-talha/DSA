package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

    /*
    * We are given an array-[0 3 4 7 9 10], cows=4
    * The array consists of different stall numbers, where cows can
    * be placed.
    *
    * We need to place the given cows such that the maximum distance
    * b/w any two cows must be min.
    *
    * Ex:
    * [0  3  4  7  9  10]
    * c1 c2 c3 c4 - dist b/w c1 & c2 is 3, dist b/w c2 & c3 is 1
    * dist b/w c3 & c4 is 3, hence the min dist. b/w any two cows is 1
    * but this is not max, as we can try to see if other config of cows
    * might give us a greater distance b/w two cows and also accommodate
    * k cows
    *
    * Hence, we need to try and see if we are able to place all the 4
    * cows by maintaining a min dist. b/w any two cows i.e dist of 2, 3,
    * 4 etc until we fail.
    *
    * since there will be at least 2 cows, the min dist b/w the 2 cows
    * will be 1 and the max can be (max stalls - min stalls).
    *
    * Hence, first we loop from a dist 1-(max-min).
    * Then we place k cows in different stalls maintaining the dist,
    * and check the dist b/w two consecutive cows, as min dist can
    * only be b/w two consecutive cows
    *
    * We also make sure that for a given distance all the k cows must
    * be placed, else the distance is not valid.
    * */


    public static void main(String[] args) {
        int[] nums = {1,2,4,8,9};
//        int ans = aggressiveCowsBrute(nums, 4);
        int ans = aggressiveCowsOp(nums, 3);
        System.out.println(ans);
    }

    static int aggressiveCowsOp(int[] nums, int cows){
        int n = nums.length;
        Arrays.sort(nums);
        int low = 1, high = nums[n-1] - nums[0];

        while (low<=high){
            int mid = (low+high)/2;
            if (isValidDistance(nums, mid, cows)){
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return high;
    }

    static int aggressiveCowsBrute(int[] nums, int cows){
        int min = findMin(nums), max = findMax(nums);
        int ans = -1;
        for (int i = 1; i <= (max-min); i++){
            if (isValidDistance(nums, i, cows)){
                ans=i;
            }
        }
        return ans;
    }

    static Boolean isValidDistance(int[] nums, int distance, int cows){
        int n = nums.length;
        int count = 1;
        int lastStall = nums[0];

        for (int i = 1; i < n; i++){
            if (nums[i] - lastStall >= distance){
                count++;
                lastStall=nums[i];
            }
            if (count >= cows) return true;
        }
        return false;
    }

    static int findMin(int[] nums){
        int min = Integer.MAX_VALUE;

        for (int num: nums){
            min = Math.min(num, min);
        }
        return min;
    }

    static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int num: nums){
            max = Math.max(num, max);
        }
        return max;
    }
}
