package TwoDArrays;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int [][] nums = {
                {1, 2, 3},
                {4, 5, 6}
        };
        transposeMatrix(nums);
    }

    public static void transposeMatrix(int [][] nums){
        /* In a transpose of a matrix the i,j in transpose will be the j,i of the
        * given array i.e. trans[i][j] = nums[j][i].
        * ex: trans[1][0] will be nums[0][1], trans[2][1] will be nums[1][2] and so on*/

        int numRows = nums.length;
        int numCols = nums[0].length;

        int [][] trans = new int[numCols][numRows];

        int transRows = trans.length;
        int transCols = trans[0].length;

        for (int i = 0; i < transRows; i++){
            for (int j = 0; j < transCols; j++){
                trans[i][j] = nums[j][i];
            }
        }

        System.out.println(Arrays.deepToString(trans));
    }
}
