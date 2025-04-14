import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeftRotateArrayByKPlaces {
    public static void main(String[] args) {
//        rotateArrayByKPlaces();
        rotateArrayByKPlacesOptimal();
    }

    public static void rotateArrayByKPlaces(){
        int [] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2 % arr.length;

        List<Integer> list = new ArrayList<>();

//        Creating a temp array with elements from i - k
        for (int i = 0; i < k; i++){
            list.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++){
            arr[i - k] = arr[i];
        }

        int j = 0;
        for (int i = arr.length - k; i < arr.length; i++){
            arr[i] = list.get(j);
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArrayByKPlacesOptimal(){
        Integer [] arr = {1, 2, 3, 4, 5, 6, 7};

        List<Integer> list = Arrays.asList(arr);

        Collections.reverse(list.subList(0, 2));
        Collections.reverse(list.subList(2, arr.length));
        Collections.reverse(list);

        System.out.println(list);
    }
}
