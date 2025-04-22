package Strings;

public class IsPalindrome {
    public static void main(String[] args) {
        boolean result = isPalindrome("ababa");
        System.out.println(result);
    }

    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;

        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
