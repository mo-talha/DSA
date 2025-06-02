import java.util.Arrays;

public class ProductOfArrayExcepSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int [] ans = productOfArrayExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
//        optimised();
//        optimised2();

    }

//
    public static int[] productOfArrayExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            int product = 1;
            for (int j = 0; j < nums.length; j++){
                if (i != j) product*= nums[j];
            }
            ans[i] = product;
        }
        return ans;
    }

    public static void optimised(){
        /*
        * Here instead of maintaining two separate arrays for prefix and suffix. We will directly store the
        * prefix to the ans array and then calculate the prefix and multiply the prefix at each index with
        * suffixes stored at that index
        * */
        int[]nums = {1, 2, 3, 4};
//        [1, 1, 2, 6]
        int [] ans = new int[nums.length];
        ans[0] = 1;

        for (int i = 1; i < nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int suffix = 1;

        for (int j = nums.length - 2; j >= 0; j--){
            suffix *= nums[j+1];
            ans[j] *= suffix;
        }

        System.out.println(Arrays.toString(ans));
    }

    /*
    * To get the product of elems excluding the cur elem
    * W.K.T we need product of elms to the left of cur elem and prod of elms to the right of cur elem
    * To get the prod to the left of cur elem or prefix, we can initialize an array called prefix with its
    * 0th index assigned to 1
    * We can start a loop from 1st index and get the prod of elms to the left of cur index
    * we can do prefix[cur index] = nums[cur index - 1] * prefix[cur index - 1]
    *
    * Similarly to get the prod of elms to the right of the cur elm or suffix
    * we can initialize a suffix array of nums.length and we can initialize its suffix[nums.len - 1] = 1
    * We start the loop from nums.len - 2 index and to get the suffix/ prod of elms to the right except at cur index will be
    * we can do suffix[i] = nums[i+1] * suffix[i+1]
    *
    * finally we can loop over the nums from 0 and ans[i] will be prefix[i] * suffix[i]
    *  */

    public static void optimised2(){
        int[]nums = {1, 2, 3, 4};
        int [] ans = new int[nums.length];

        int[] prefix = new int[nums.length];
        prefix[0] = 1;

        for (int i = 1; i < nums.length; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--){
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for (int i = 0; i < nums.length; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        System.out.println(Arrays.toString(ans));
    }

}

