import java.util.HashSet;
import java.util.Set;

public class NumAppearingOnce {
//    Find the number that appears once, others twice
    public static void main(String[] args) {
//        numAppearingOnce();
        numAppearingOnce2();
    }

    public static void numAppearingOnce(){
        int [] arr = {4,1,2,1,2};
        Set<Integer> unique = new HashSet<>();

        for (int i: arr){
            if (unique.contains(i)){
                unique.remove(i);
            } else {
                unique.add(i);
            }

        }
        System.out.println(unique.stream().toList().get(0));
    }

    public static void numAppearingOnce2(){
        int [] nums = {1, 1, 2};

        int result = 0;

        for (int num: nums){
            result ^= num;
        }

        System.out.println(result);
    }
}
