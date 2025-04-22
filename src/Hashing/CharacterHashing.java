package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class CharacterHashing {
    public static void main(String[] args) {
//        frequencyOfCharacters();
//        frequencyOfCharacters2();
        frequencyOfCharacters3();
    }

    public static void frequencyOfCharacters(){
        String s = "aabbaad";

        int [] hash = new int[26];
        for (int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(hash));
    }

    public static void frequencyOfCharacters2(){
        int [] nums = {1, 2, 2, 3, 4};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            if (map.get(num) == null){
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
            }
        }

        System.out.println(map);
    }

    public static void frequencyOfCharacters3(){
        String s = "aabaabc";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == null){
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        System.out.println(map);
    }

    public static void frequencyOfCharacters4(){
        String s = "aabaabc";
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character character: s.toCharArray()){
//            getOrDefault method checks if the character is present, if yes then its value is incremented by 1, else
//            its stored as 1.
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        System.out.println(map);
    }
}
