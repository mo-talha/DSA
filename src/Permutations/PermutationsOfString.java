package Permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {
    public static void main(String[] args) {
//        StringBuilder s = new StringBuilder();
        String s = "abcd";
        int[] freq = new int[26];
        for (char c: s.toCharArray()){
            freq[c-'a'] +=1;
        }
        ArrayList<String> res = new ArrayList<>();
        permutations(s, freq, res, new StringBuilder());
        System.out.println(res);
    }

    public static void permutations(String s, int[] freq, List<String> res, StringBuilder temp) {
        if (temp.length() == s.length()) {
            res.add(temp.toString());
            return;
        }
        for (int i = 0; i < freq.length; i++){
            if (freq[i] == 0) continue;
            char c = (char) ('a' + i);
            temp.append(c);
            freq[i] -= 1;
            permutations(s, freq, res, temp);

            temp.deleteCharAt(temp.length()-1);
            freq[i]+=1;
        }
    }
}
