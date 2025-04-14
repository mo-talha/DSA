import java.util.Arrays;

public class IsAnagram {
    public static void main(String[] args) {
        isAnagram();
    }

    public static void isAnagram(){
        String str1 = "TOM";
        String str2 = "Mmm";

        if (str1.length() != str2.length()){
            System.out.println("Not Anagram");
            return;
        }

        char [] charArrStr1 = str1.toCharArray();
        char [] charArrStr2 = str2.toCharArray();

        Arrays.sort(charArrStr1);
        Arrays.sort(charArrStr2);

        String newStr1 = new String(charArrStr1);
        String newStr2 = new String(charArrStr2);

        if (newStr1.equals(newStr2)){
            System.out.println("Is Anagram");
        }
        System.out.println("Not Anagram");
    }
}
