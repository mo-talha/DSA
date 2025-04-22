package Hashing;

import java.util.Arrays;

public class HashIndicies {
    public static void main(String[] args) {
        int [] nums = {3,3,3,2};
        hash(nums);
    }

    public static void hash(int [] nums){
        int [] hash = new int[nums.length];

        for (int num:nums){
            hash[num-1]++;
        }
        System.out.println(Arrays.toString(hash));
    }
}
