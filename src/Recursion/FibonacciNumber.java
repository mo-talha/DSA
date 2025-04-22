package Recursion;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        int result = nthFibonacciNum(5);
        System.out.println(result);
    }

    public static int nthFibonacciNum(int n){
//        Because 0th fibo num is 0 and 1st fibo num is 1
        if (n <= 1){
            return n;
        }
//        Here first nthFibonacciNum(n - 1) is called and then the caller method waits for it to return
//        and then nthFibonacciNum(n - 2) is called and is awaited until its return.
//        The recursion calls happen synchronously.
        return nthFibonacciNum(n - 1) + nthFibonacciNum(n - 2);
    }
}

