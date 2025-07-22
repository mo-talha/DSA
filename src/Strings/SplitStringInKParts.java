package Strings;

import java.util.ArrayList;
import java.util.List;

public class SplitStringInKParts {
    public static void main(String[] args) {
        String s = "abcde";
        splitInKParts(s, 4);
    }

    public static void splitInKParts(String s, int k){
        int n = s.length();
        int remainder = n % k;
        int baseLen = n/k;
        List<String> parts = new ArrayList<>();

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < n; i++){
            string.append(s.charAt(i));
            if (remainder == 0){
                if (string.length() == baseLen){
                    parts.add(string.toString());
                    string.setLength(0);
                }
            }
            if (parts.size() == remainder && string.length() == baseLen){
                parts.add(string.toString());
                string.setLength(0);
            }
            else if (string.length() == baseLen + 1){
                parts.add(string.toString());
                string.setLength(0);
            }
        }

//        parts.add(string.toString());

        System.out.println(parts);
    }
}
