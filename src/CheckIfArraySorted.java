

public class CheckIfArraySorted {
    public static void main(String[] args) {
        System.out.println(checkArraySorted());
    }

    public static boolean checkArraySorted(){
        int [] arr = {1, 0, 3 ,4};

        for (int i = 1; i < arr.length; i++){
            if (arr[i] >= arr[i-1]){
            } else {
                return false;
            }
        }
        return true;
    }
}
