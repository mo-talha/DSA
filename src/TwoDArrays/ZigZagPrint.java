package TwoDArrays;

public class ZigZagPrint {
    public static void main(String[] args) {
//        System.out.println(0%2);
        int [][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        zigZagPrint(nums);
    }

    public static void zigZagPrint(int [][] nums){
        int rows = nums.length;
        int cols = nums[0].length;

        for (int i = 0; i < rows; i++){
            if (i%2 == 1){
                for (int j = cols - 1; j >= 0; j--){
                    System.out.println(nums[i][j]);
                }
            } else {
                for (int j = 0; j < cols; j++){
                    System.out.println(nums[i][j]);
                }
            }
        }
    }
}
