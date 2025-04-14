import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        Integer [] arr = {1,2, 3, 4};
        reverseArray(arr, 0, arr.length);
    }
    public static void reverseArray(Integer[] arr, int START_INDEX, int END_INDEX) {
        END_INDEX = END_INDEX - 1;
        while (START_INDEX <= END_INDEX){
            int temp = arr[END_INDEX];
            arr[END_INDEX] = arr[START_INDEX];
            arr[START_INDEX] = temp;

            START_INDEX++;
            END_INDEX--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
