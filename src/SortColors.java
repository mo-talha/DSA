import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
//        sortColors();
        sortColor2();
    }

    public static void sortColors(){
//        int [] arr = {2, 0, 1, 3};
        int [] arr = {2,0,2,1,1,0};
        int i = 0;

        for (int j = 1; j < arr.length; j++){
            if (arr[j] < arr[i]){
                swap(arr, i, j);
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int [] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sortColor2(){
//        int [] arr = {2,0,2,1,1,0};
        int [] arr = {2, 0, -1};
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j= i+1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min=j;
                }
            }
            swap(arr, i, min);
        }
        System.out.println(Arrays.toString(arr));
    }
}
