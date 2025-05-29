package TwoDArrays;

import java.util.Arrays;

public class Search2dArray {

    public static void main(String[] args) {
        int [][] nums = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int target = 6;

        int [] ans = search2dArray(nums, 99);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] search2dArray(int [][] nums, int target){
        int rows = nums.length;
        int cols = nums[0].length;
        int [] ans = {-1, -1};
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (nums[i][j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
