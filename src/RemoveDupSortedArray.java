import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDupSortedArray {
    public static void main(String[] args) {
//        removeDuplicates();
//        removeDupsOptimal();
        printNum();
    }

    public static void removeDuplicates(){
        int [] arr = {1, 1, 2, 3, 3};

//        Set<Integer> uniqueElems = new HashSet<>();

        HashSet<Integer> uniqueElems = new HashSet<>();

        for (int i = 0; i < arr.length; i++){
            uniqueElems.add(arr[i]);
        }

        int j = 0;
        for (int i:uniqueElems){
            arr[j] = i;
            j++;
        }

        System.out.println(j);
        System.out.println(Arrays.toString(arr));
    }

    public static void removeDupsOptimal(){
        int [] arr = {1, 1, 2, 2, 3, 3};

        int i = 0;
        for (int j = 1; j < arr.length; j++){
            if (arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(i+1);
    }

    public static void printNum(){
        System.out.println(1);
        printNum();
        try {
            Thread.sleep(10000000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
