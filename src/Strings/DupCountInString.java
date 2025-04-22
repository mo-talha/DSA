package Strings;

import java.util.HashMap;
import java.util.Map;

public class DupCountInString {
    public static void main(String[] args) {
        countDuplicates();
    }

    public static void countDuplicates(){
        String s = "TaaazT";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if (entry.getValue() > 1){
                System.out.println("Char: "+entry.getKey()+", occurences: "+entry.getValue());
            }
        }
    }
}
