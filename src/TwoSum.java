import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TwoSum {
    public static void main(String[] args) {
//        twoSum();
//        twoSumTwoPointer();
        twoSumBetter();
    }

    public static void twoSum(){
        int [] nums = {3,3};
        int target = 6;

        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                sum = nums[i] + nums[j];

                if (sum == target){
                    System.out.println(List.of(i,j));
                }
            }
        }
    }

    public static void twoSumTwoPointer(){
        int [] nums = {1,2,3,4};
        int target = 7;
        int start = 0;
        int end = nums.length - 1;

        while (start < end){
            if (nums[start] + nums[end] == target){
                System.out.println(List.of(start, end));
                break;
            } else {
                end--;
            }
            if (start == end){
                end = nums.length - 1;
                start++;
            }
        }
    }

    public static void twoSumBetter(){
        int [] nums = {1,2,3,4};
        int target = 7;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int checkNum = target - nums[i];
            if (map.get(checkNum) != null){
                System.out.println(List.of(map.get(checkNum), i));
            } else {
                map.put(nums[i], i);
            }
        }
    }
}
