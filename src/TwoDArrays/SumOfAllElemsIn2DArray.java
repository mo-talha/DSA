package TwoDArrays;

public class SumOfAllElemsIn2DArray {
    public static void main(String[] args) {
        int [][] nums = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int ans = sumOfAllElems(nums);
        System.out.println(ans);
    }

    public static int sumOfAllElems(int [][] nums){
        int sum = 0;

        int rows = nums.length;
        int cols = nums[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                sum += nums[i][j];
            }
        }

        return sum;
    }
}
