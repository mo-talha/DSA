public class SecondLargest {
    public static void main(String[] args) {
//        secondLargest();
        secondMaxOptimal();
    }

    public static void secondLargest(){
        int [] nums = {1, 2, 4, 3};

        int FIRST_MAX = -1;
        int SECOND_MAX = -1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > FIRST_MAX){
                FIRST_MAX = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] < FIRST_MAX){
                SECOND_MAX = nums[i];
            }
        }

        System.out.println("First Max: "+FIRST_MAX +", Second Max: "+SECOND_MAX);
    }

    public static void secondMaxOptimal(){
        int [] nums = {1, 2, 4, 3};

        Integer FIRST_MAX = Integer.MIN_VALUE;
        Integer SECOND_MAX = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > FIRST_MAX){
                SECOND_MAX = FIRST_MAX;
                FIRST_MAX = nums[i];
            } else if (FIRST_MAX > nums[i] & nums[i] > SECOND_MAX) {
                SECOND_MAX = nums[i];
            }
        }

        System.out.println("First Max: "+FIRST_MAX +", Second Max: "+SECOND_MAX);
    }
}
