package Recursion;

import java.util.Arrays;

public class OneToNUsingRecursion {
    public static void main(String[] args) {
//        oneToN(1, 10);
//        printNtoOne(10);
//        sumOfNnumbers(5, 0);
//        sumOfNnumbers2(5.0, 0.0);
//        int result = sumOfNnumbers3(3);
//        System.out.println(result);

//        Double result = sumOfNnumbers4(3.0);
//        System.out.println(result);
//        int result = factorialOfN(4);
//        System.out.println(result);

//        factorialOfNParameterized(3, 1);
        int [] nums = {1, 2, 3, 4};
//        reverseAnArray(nums, 0, nums.length-1);
        reverseAnArrayFunctional(nums, 0);
//        reverseArray(nums);
        checkIfStringIsPalindrome("ababa", 0);
    }

    public static void oneToN(int i, int n){
        if (i > n){
            return;
        }
        System.out.println(i);
        oneToN(i+1, n);
    }

    public static void printNtoOne(int n){
        if (n < 1){
            return;
        }
        System.out.println(n);
        printNtoOne(n - 1);
    }

//    Parameterized way
    public static void sumOfNnumbers(int n, int sum){
        if (n < 0){
            System.out.println(sum);
            return;
        }
        sumOfNnumbers(n - 1, sum + n);
    }

    public static void sumOfNnumbers2(Double n, Double sum){
        if (n < 0){
            System.out.println(sum);
            return;
        }
        sumOfNnumbers2(n - 1, sum + Math.pow(n, 3));
    }

//    Functional way
    public static int sumOfNnumbers3(int n){
        if (n == 0){
            return 0;
        }
        return n + sumOfNnumbers3(n - 1);
    }

    public static Double sumOfNnumbers4(Double n){
        if (n == 0.0){
            return 0.0;
        }
        return Math.pow(n, 3) + sumOfNnumbers4(n - 1);
    }

    public static int factorialOfN(int n){
        if (n == 1){
            return 1;
        }
        return n * factorialOfN(n - 1);
    }

    public static void factorialOfNParameterized(int n, int factorial){
        if (n == 1){
            System.out.println(n * factorial);
            return;
        }
        factorialOfNParameterized(n - 1, n * factorial);
    }

    public static void reverseAnArray(int [] nums, int start, int end){
        if (start >= end){
            System.out.println(Arrays.toString(nums));
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        reverseAnArray(nums, start+1, end - 1);
    }

    public static void reverseAnArrayFunctional(int [] nums, int start){
        if (start >= nums.length/2){
            System.out.println(Arrays.toString(nums));
            return;
        }

        int temp = nums[start];
        nums[start] = nums[nums.length - start - 1];
        nums[nums.length - start - 1] = temp;

        reverseAnArrayFunctional(nums, start+1);
    }

    public static void reverseArray(int [] nums){
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void checkIfStringIsPalindrome(String s, int i){
        if (i >= s.length()/2){
            System.out.println(true);
            return;
        }
        if (s.charAt(i) == s.charAt(s.length() - i - 1)){
            checkIfStringIsPalindrome(s, i+1);
        }
    }
}
