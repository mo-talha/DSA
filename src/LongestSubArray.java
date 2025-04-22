public class LongestSubArray {
    public static void main(String[] args) {
        longestSubArrayBrute();
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
}

