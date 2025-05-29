package TwoDArrays;

public class PrintDiagnols {
    public static void main(String[] args) {
        int [][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printDiagNols(nums);
    }

    public static void printDiagNols(int [][] nums){
        int rows = nums.length;
        int cols = nums[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (i == j) System.out.println(nums[i][j]);
            }
        }
    }
}
