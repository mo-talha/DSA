import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeftRotateArray {
    public static void main(String[] args) {
//        leftRotateArray();
//        k = 2, 3,4,5,6,7,1,2
//        2, 1, 3, 4, 5, 6, 7
//        2, 1, 7, 6, 5, 4, 3
//        3, 4, 5, 6, 7, 1, 2
//        Integer [] arr = {1, 2, 3, 4, 5, 6, 7};
//        List<Integer> list = Arrays.asList(arr);
//        Collections.reverse(list.subList(0, 3));
//
//        System.out.println(Arrays.toString(arr));
//        leftRotatebyKSteps(arr, 20);
//        System.out.println(20 % 7);
        leftRotateByKStepsReverse(3);
//        Reverse();
    }

    public static void leftRotateByKStepsReverse(int k){
        Integer [] arr = {1, 2, 3, 4, 5, 6, 7};
        Reverse(arr, 0, k);
        Reverse(arr, k, arr.length - 1);
        Reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //        List<Integer> list = Arrays.asList(arr);
//
//        Collections.reverse(list.subList(0, 3));
//        Collections.reverse(list.subList(3, list.size()));
//        Collections.reverse(list);

//        System.out.println(list);
    }

    public static void Reverse(Integer [] arr ,int STARTINDEX, int ENDINDEX){
//        Integer [] arr = {1, 2, 3, 4};
//        int STARTINDEX = 0;
//        int ENDINDEX = 3;

        while (STARTINDEX <= ENDINDEX){
            int temp = arr[STARTINDEX];
            arr[STARTINDEX] = arr[ENDINDEX];
            arr[ENDINDEX] = temp;

            STARTINDEX++;
            ENDINDEX--;
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void leftRotatebyKSteps(int [] arr, int k){
//        int [] arr = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3 % arr.length;
        k = k % arr.length;

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < k; i++){
            temp.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++){
            arr[i - k] = arr[i];
        }

        int j = 0;
        for (int i = arr.length - k; i< arr.length; i++){
            arr[i] = temp.get(j);
            j++;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void leftRotateArray(){
        int [] arr  = {1,2,3,4};
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++){
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;

        System.out.println(Arrays.toString(arr));
    }
}

