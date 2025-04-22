package Strings;

public class OneStringRotaionOfAnother {
    public static void main(String[] args) {
        Boolean result = rotatedString("Taz", "zaT");
        System.out.println(result);
    }

    public static boolean rotatedString(String s1, String s2) {
        String stringBuilderS2 = new StringBuilder(s2).reverse().toString();


        if (stringBuilderS2.equals(s1)){
            return true;
        } else {
            return false;
        }
    }
}
