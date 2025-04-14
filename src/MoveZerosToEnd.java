import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZerosToEnd {
    public static void main(String[] args) {
//        moveZeros();
//        moveZeros2();
        moveZeros3();
    }

    public static void moveZeros(){
        int [] arr = {1, 0, 2, 3, 4, 0, 0, 5, 6};

        ArrayList<Integer> nonZeros = new ArrayList<>();

//        O(N)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                nonZeros.add(arr[i]);
            }
        }

        for (int i = 0; i < nonZeros.size(); i++){
            arr[i] = nonZeros.get(i);
        }

        for (int i = nonZeros.size(); i < arr.length; i++){
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void moveZeros2(){
        int [] arr = {1, 0, 2, 3, 0, 4};

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < arr.length){
            arr[index] = 0;
            index++;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeros3(){
        int [] arr = {1, 0, 2, 3, 0, 4};
        int j = -1;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                j = i;
                break;
            }
        }

        for (int i = j+1; i< arr.length; i++){
            if (arr[i] != 0){
                swap(arr, i, j);
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[]arr ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
