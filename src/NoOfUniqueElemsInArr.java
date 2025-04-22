import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NoOfUniqueElemsInArr {
    public static void main(String[] args) {
        countUniqueElemsInArray();
    }

    public static void countUniqueElemsInArray() {
        int [] nums = {1, 2, 2, 3, 4, 5};

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        System.out.println(set.size());
    }
}
