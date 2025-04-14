package Recursion;

public class NameNTimes {
    public static void main(String[] args) {
        printNamesNTimes(1, 4);
    }

    public static void printNamesNTimes(int i, int n){
        if (i > n){
            return;
        }
        System.out.println("Taz");
        printNamesNTimes(i+1, n);
    }
}
