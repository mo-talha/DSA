import java.util.*;

public class UnionOfArrays {
    public static void main(String[] args) {
//        union();
//        union2();
        union3();
    }

    public static void union(){
        int [] nums1 = {1, 2, 3, 4, 5};
        int [] nums2 = {1, 2, 3, 6, 7};

        Set<Integer> unique = new HashSet<>();

        for (int num: nums1){
            unique.add(num);
        }

        for (int num: nums2){
            unique.add(num);
        }

        ArrayList<Integer> aa = new ArrayList<>(unique);
        Collections.sort(aa);
        System.out.println(aa);

//        System.out.println(Arrays.toString(unique.toArray()));
    }

    public static void union2(){
        int [] nums1 = {1, 2, 2, 3};
        int [] nums2 = {1, 3, 4, 5};

        int size1 = nums1.length - 1;
        int size2 = nums2.length - 1;

        int i = 0;
        int j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while (i <= size1 & j <= size2){
            if (nums1[i] <= nums2[i]){
                if (union.size() == 0 || union.contains(nums1[i]) == false){
                    union.add(nums1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.contains(nums2[j])){
                    union.add(nums2[j]);
                }
                j++;
            }
        }

        while (i <= size1) {
                if (union.size() == 0 || union.contains(nums1[i]) == false) {
                    union.add(nums1[i]);
                }
                i++;
            }

        while (j <= size2){
            if (union.size() == 0 || union.contains(nums2[j]) == false) {
                union.add(nums2[j]);
            }
            j++;
        }

        System.out.println(union);
    }

    public static void union3(){
        int [] nums1 = {1, 2, 2, 3};
        int [] nums2 = {1, 3, 4, 5};

        int size1 = nums1.length - 1;
        int size2 = nums2.length - 1;

        int i = 0;
        int j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while (i <= size1){
            if (union.isEmpty() || union.contains(nums1[i]) == false){
                union.add(nums1[i]);
            }
            i++;
        }

        while (j <= size2){
            if (union.isEmpty() || union.contains(nums2[j]) == false){
                union.add(nums2[j]);
            }
            j++;
        }

        System.out.println(union);
    }
}
