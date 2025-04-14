package Recursion;

public class Recursion {
    public static void main(String[] args) {
        printNums();
    }

    static int count = 0;
    public static void printNums(){
        if (count == 4){
            return;
        }
        System.out.println("Taz");
        count++;

        printNums();
    }
}
