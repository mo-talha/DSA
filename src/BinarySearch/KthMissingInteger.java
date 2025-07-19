package BinarySearch;

import java.util.Arrays;

public class KthMissingInteger {
    public static void main(String[] args) {
       int[] nums = {1,2,3,4};
//       int ans = hash(nums, 2);
        int ans = kthMissingInt(nums, 2);
       System.out.println(ans);
    }

    static int kthMissingInt(int[] nums, int k){
        int n = nums.length-1;
        int low = 0, high = n;

        while (low<=high){
            int mid = (low+high)/2;

            int missingNos = nums[mid] - (mid + 1);

            if (missingNos < k){
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return high + 1 + k;
    }

    static int hash(int[] nums, int k){
        int maxElem = 1000;
        int[] hash = new int[maxElem+1];

        for (int num: nums){
            hash[num] = 1;
        }

//        System.out.println(Arrays.toString(hash));

        int count = 0;
        for (int i=1; i < hash.length; i++){
            if (hash[i] != 1) count+=1;
            if (count==k) return i;
        }
        return -1;
    }

    static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int num: nums){
            max = Math.max(num, max);
        }

        return max;
    }
}
