import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
//        sortColors();
//        sortColorsBetter();
        sortColorsDutchFlagAlgo();
    }

    public static void sortColors(){
        int [] arr = {2,0,2,1,1,0};
//        int [] arr = {2, 0, -1};
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

    public static void swap(int [] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sortColorsBetter(){
        int [] nums = {2,0,2,1,1,0};
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int num : nums){
            if (num == 0){
                zeros++;
            } else if (num == 1){
                ones++;
            } else {
                twos++;
            }
        }

//        for (int i = 0; i < zeros; i++){
//            nums[i] = 0;
//        }
//
//        for (int i = zeros; i < ones+ones; i++){
//            nums[i] = 1;
//        }
//
//        for (int i = ones+ones; i < twos+twos; i++){
//            nums[i] = -1;
//        }
        int index = 0;

        // Insert zeros
        for (int i = 0; i < zeros; i++) {
            nums[index++] = 0;
        }

        // Insert ones
        for (int i = 0; i < ones; i++) {
            nums[index++] = 1;
        }

        // Insert twos
        for (int i = 0; i < twos; i++) {
            nums[index++] = 2;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void sortColorsDutchFlagAlgo(){
        int [] nums = {0, 0, 2, 1, 2, 1};
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high){
            if (nums[mid] == 0){
                swap(nums, mid, low);
                mid+=1;
                low+=1;
            } else if (nums[mid] == 1) {
                mid+=1;
            } else {
                swap(nums, mid, high);
                high-=1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
