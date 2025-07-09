package BinarySearch;

public class SquareRootOfN {
    public static void main(String[] args) {
//        int ans = sqrtOfN(28);
        int ans = sqrtOfNBrute(16);
        System.out.println(ans);
    }

    static int sqrtOfNBrute(int n){
        int ans = -1;

        for (int i = 1; i <= n; i++){
            if (i*i <= n){
                ans=i;
            }
        }

        return ans;
    }

    static int sqrtOfN(int n){
        int low = 1, high = n;

        while (low <= high){
            int mid = (low+high)/2;
            int square = mid*mid;

            if (square <= n){
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return high;
    }
}
