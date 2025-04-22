import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "1432219";
        int k = 3;

        StringBuilder stringBuilder = new StringBuilder(s);
        int lowest = 0;
        String curString = "";

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (k+i < s.length()){
                String replace = s.substring(i, k + i);
                String replacedSubString = s.replace(replace, "");
                lowest = Integer.parseInt(replacedSubString);
                list.add(lowest);
            }
        }

        int min = list.get(0);

        for (int num: list){
            if (num < min){
                min = num;
            }
        }
        System.out.println(min);
    }
}

