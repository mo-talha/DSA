package BinarySearch;

public class OccurrencesOfANum {
    public static void main(String[] args) {
        int[] nums = {4,4,5,5,5,9};
        int ans = countOccurrencesOfK(nums, 4);
        System.out.println(ans);
    }

    static int countOccurrencesOfK(int[] nums, int target){
        int ub = FirstAndLastPosition.findUpperBound(nums, target);
        int lb = FirstAndLastPosition.findLowerBound(nums, target);
        return ub-lb;
    }


}
