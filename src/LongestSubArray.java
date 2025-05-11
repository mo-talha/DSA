import java.util.HashMap;

public class LongestSubArray {
    public static void main(String[] args) {
//        longestSubArrayBrute();
//        int target = 15;
//        int [] nums = {10, 5, 2, 7, 1};
//        longestSubArrayBrute2(nums, target);
//        optimalSolution();
        bestSolution();
    }

    public static void longestSubArrayBrute(){
        int target = 15;
        int [] nums = {10, 5, 2, 7, 1, -10};

        int len = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum == target) {
                    len = Integer.max(len, j - i + 1);
                }
            }
        }
        System.out.println(len);
    }

    public static void longestSubArrayBrute2(int [] nums, int target) {
//        int [] nums = {10, 5, 2, 7, 1};
        int len = 0;
        for (int i = 0; i < nums.length; i++){
            int curSum = 0;
            for (int j = i; j < nums.length; j++){
                curSum+=nums[j];

                if (curSum == target){
                    len = Integer.max(len, j - i + 1);
                }
            }
        }
        System.out.println(len);
    }

    static void longestSubarraySumOptimal(int [] nums, int target){
        int prefixSum = 0;
        int len = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];

            if (prefixSum == target) {
                len = i + 1;
                maxLen = Integer.max(len, maxLen);
            }

            int rem = prefixSum - target;

            if (prefixMap.containsKey(rem)){
                int j = prefixMap.get(rem);
                len = i - j;
                maxLen = Integer.max(len, maxLen);
            }

            if (!prefixMap.containsKey(prefixSum)){
                prefixMap.put(prefixSum, i);
            }
        }
    }

//    Solution if the array consists on only positives and negatives
    private static void optimalSolution(){
        int [] nums = {10, 5, 2, 7, 1};
//                                  i
//        prefixSum = 10, 15, 17
//        maxLen =        2
//        hashmap = {10:0, 15:1, 17:2, 24:3, 25:4}
        int target = 15;

        int prefixSum = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if (prefixSum == target){
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = prefixSum - target;
            if (hashMap.containsKey(rem)){
                maxLen = Math.max(maxLen, i - hashMap.get(rem));
            }

            if (!hashMap.containsKey(prefixSum)){
                hashMap.put(prefixSum, i);
            }
        }
        System.out.println(maxLen);
    }

//    Solution for array consisting of zeros and positives only
    private static void bestSolution(){
        int [] nums = {10, -2, 7, 7, 1};
        int target = 15;

        int start = 0;
        int end = 0;

        int maxLen = 0;

        int prefixSum = nums[0];

        while (end <= nums.length){
            while (start <= end && prefixSum > target){
                prefixSum -= nums[start];
                start++;
            }
            if (prefixSum == target){
                maxLen = Math.max(maxLen, end - start + 1);
            }
            end++;
            if (end < nums.length ) prefixSum += nums[end];
        }
        System.out.println(maxLen);
    }
}

