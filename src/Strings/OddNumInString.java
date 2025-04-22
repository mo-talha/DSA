package Strings;

import java.util.ArrayList;

public class OddNumInString {
    public static void main(String[] args) {
        String result = largestOddNumInString("4206");
        System.out.println(result);
    }

    public static String largestOddNumInString(String s){
        for (int i = s.length() - 1; i >= 0; i--){
            if (Integer.valueOf(s.charAt(i)) % 2 == 1){
                return s.substring(0, i+1);
            }
        }
        return "";
    }
}

/*
* 155576
* */
