package Hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyNumMinFrequencyNum {
    public static void main(String[] args) {
        maxOccrNumMinOccrNum();
    }

    public static void maxOccrNumMinOccrNum(){
        int [] nums = {1, 2, 2};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int maxFreqElem = -1; // 2
        int minFreqElem = -1; // 1

        int maxFreq = Integer.MIN_VALUE; // 2
        int minFreq = Integer.MAX_VALUE; // 1

        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()){
            int elem = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFreq){
                maxFreq = freq;
                maxFreqElem = elem;
            }

            if (freq < minFreq){
                minFreq = freq;
                minFreqElem = elem;
            }
        }

        System.out.println("Max Freq Elem: "+maxFreqElem+" Frequency: "+maxFreq);
        System.out.println("Min Freq Elem: "+minFreqElem+" Frequency: "+minFreq);
    }
}
