package Strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
       String result = reverseString("Taz");
        System.out.println(result);
    }

    public static String reverseString(String s){
        int start = 0;
        int end = s.length() - 1;

        char [] charArr = s.toCharArray();

        while (start < end){
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;

            start++;
            end--;
        }
        return new String(charArr);
    }
}
