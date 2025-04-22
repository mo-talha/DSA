package TwoDArrays;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int [][] arr = new int[2][2];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < 2; j++){
                arr[i][j] = j;
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }


}
