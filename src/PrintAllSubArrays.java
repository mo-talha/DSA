public class PrintAllSubArrays {
    public static void main(String[] args) {
        printAllSubArrays();
    }

    public static void printAllSubArrays(){
        int [] nums = {1, 2, 3, 4};
//        int maxSum = Integer.MIN_VALUE;
        /*
        [1], [1,2], [1, 2, 3], [1, 2, 3, 4]
        [2], [2, 3], [2, 3, 4]
        [3], [3, 4]
        [4]
        */
        for (int st = 0; st < nums.length; st++){
            for (int end = st; end < nums.length; end++){
                for (int i = st; i <= end; i++){
                    System.out.print(nums[i]);
                }
                System.out.print(" ");
            }
        }
    }
}
