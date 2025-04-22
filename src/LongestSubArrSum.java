public class LongestSubArrSum {
    public static void main(String[] args) {
//        longestSubArraySum();
        longestSubArraySumUsingKadanesAlgo();
    }

    public static void longestSubArraySum(){
        int [] nums = {3, -4, 5, 4, -1, 7, -8};

        int maxSum = 0;
        for (int st = 0; st < nums.length; st++){
            int curSum = 0;
            for (int end = st; end < nums.length; end++){
                curSum += nums[end];
                maxSum = Integer.max(curSum, maxSum);
            }
        }
        System.out.println(maxSum);
    }

    public static void longestSubArraySumUsingKadanesAlgo(){
        int [] nums = {3, -4, 5, 4, -1, 7, -8};

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++){
            curSum += nums[i];
            maxSum = Integer.max(curSum, maxSum);

            if (curSum < 0) {
                curSum = 0;
            }
        }

        System.out.println(maxSum);
    }
}
