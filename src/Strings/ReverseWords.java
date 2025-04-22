package Strings;

public class ReverseWords {
    public static void main(String[] args) {
        String result = reverseWords("the sky    is blue");
        System.out.println(result);

        String result2 = reverseWordsOptimised("the sky    is blue");
        System.out.println(result2);

    }

    public static String reverseWords(String s){
        String [] list = s.trim().split("\\s+");

        int start = 0;
        int end = list.length - 1;

        while (start < end){
            String temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;
        }

//        System.out.println(Arrays.toString(list));

        String reversedString = String.join(" ", list);
//        System.out.println(reversedString);
        return reversedString;
    }

    public static String reverseWordsOptimised(String s){
        String [] list = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--){
            reversed.append(list[i]);
            if (i!=0){
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
}
