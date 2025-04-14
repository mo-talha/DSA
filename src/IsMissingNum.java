import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IsMissingNum {
    public static void main(String[] args) {
//        missingNum();
//        missingNum2();
        missingNum3();
    }

    public static void missingNum(){
        int [] nums = {0, 2};

        for (int i = 1; i <= nums.length; i++){
            int flag = 0;

            for (int j = 0; j < nums.length; j++){
                if (nums[j] == i){
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) System.out.println(i);
        }
    }

    public static void missingNum2(){
        int [] nums = {0, 2};
        int n = nums.length;
        int sum1 = n * (n+1)/2;
        int sum2 = 0;

        for (int i = 0; i < nums.length; i++){
            sum2 += nums[i];
        }
        if (sum1 != sum2){
            System.out.println(sum1 - sum2);
        }
//        System.out.println(sum1);
    }

    public static void missingNum3() {
        int [] nums = {0, 2};
        int [] hash = new int[nums.length+1];
//        int [] hash = new int[nums.length];

        for (int i = 0; i < hash.length - 1; i++){
            hash[nums[i]]++;
        }

        for (int i = 0; i < hash.length; i++){
            if (hash[i] == 0) System.out.println(i);
        }
    }

}
