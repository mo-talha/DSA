package BinarySearch;

public class NthRootOfM {
    public static void main(String[] args) {
//        System.out.println(powerOfX(4, 2));
        int ans = findNthRootOfMBrute(3, 8);
//        int ans = findNthRootOfM(3, 8);
        System.out.println(ans);
    }

    static int findNthRootOfM(int n, int m){
        int low = 1, high = m;
        int ans = -1;
        while (low <= high){
            int mid = (low+high)/2;

            ans = powerOfX(n, mid);

            if (ans == m){
                return mid;
            } else if (ans > m) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return -1;
    }

    static int findNthRootOfMBrute(int n, int m){
        for (int i = 1; i <= m; i++){
            int ans = powerOfX(n, i);
            if (ans == m) return i;
        }
        return -1;
    }

    static int powerOfX(int n, int x){
        int ans = 1;
        for (int i = 0; i < n; i++){
            ans*=x;
        }
        return ans;
    }
}
