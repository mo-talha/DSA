package TwoDArrays;

import java.util.Arrays;

public class NonDiaElemsToZero {
    public static void main(String[] args) {
        int [][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        printDiagNols(nums);
        turnNonDiaElemsToZero(nums);
    }

    public static void turnNonDiaElemsToZero(int [][] nums){
        int rows = nums.length;
        int cols = nums[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (i != j) nums[i][j] = 0;
            }
        }

        System.out.println(Arrays.deepToString(nums));
    }
}
