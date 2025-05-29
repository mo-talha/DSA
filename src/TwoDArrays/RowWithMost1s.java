package TwoDArrays;

public class RowWithMost1s {
    public static void main(String[] args) {
        int [][] nums = {
                {1, 1, 1},
                {0, 1, 1},
                {1, 0, 0}
        };

       int ans = rowWithMost1s(nums);
       System.out.println(ans);
    }

    public static int rowWithMost1s(int [][] nums){
        int row = -1;
        int maxOnes = 0;

        int rows = nums.length;
        int cols = nums[0].length;

        for (int i = 0; i < rows; i++){
            int ones = 0;
            for (int j = 0; j < cols; j++){
                if (nums[i][j] == 1) ones++;
            }
            if (ones > maxOnes){
                maxOnes = ones;
                row = i;
            }
        }
        return row;
    }
}
