import java.util.*;

class LinkedList{
    int value;
    LinkedList next;

    public LinkedList(int value, LinkedList node){
        this.value = value;
        this.next = node;
    }
}

public class Main{
    public static void main(String[] args){
        // int[] nums = {2, 5, 1, 3};
        // int[] nums = {4, 3, 2, 1};
//         int[] nums = {6, 4, -5, 1, 8, 3, 2, -10, -4, 0, 4, -9};
//        int[][] nums = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
//        int[] nums = {5,4,3,2,1,1000000000};
//        int ans = aggressiveCows(nums, 2);
//        System.out.println(ans);
        LinkedList head = new LinkedList(1, null);
        LinkedList node2 = new LinkedList(2, null);
        head.next = node2;
        System.out.println(head.next.value);
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int min = i;
            for (int j = i+1; j < nums.length; j++){
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }

    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - i - 1; j++){
                if (nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public static void insertionSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int j = i;
            while (j > 0 && nums[j] < nums[j-1]){
                swap(nums, j, j-1);
                j-=1;
            }
        }
    }

    public static void mergeSort(int[] nums, int st, int end){
        if (st >= end) return;

        int mid = (st + end)/2;

        quickSort(nums, st, mid);
        quickSort(nums, mid+1, end);
        sort(nums, st, mid, end);
    }

    public static void sort(int[] nums, int st, int mid, int end){
        ArrayList<Integer> list = new ArrayList<>();
        int i = st, j = mid+1;
        int k = 0;

        while (i <= mid && j <= end){
            if (nums[i] <= nums[j]){
                list.add(nums[i]);
                i+=1;
            } else {
                list.add(nums[j]);
                j+=1;
            }
        }

        while(i <= mid){
            list.add(nums[i]);
            i+=1;
        }

        while(j <= end){
            list.add(nums[j]);
            j+=1;
        }

        for(int l = 0; l < list.size(); l++){
            nums[st+l] = list.get(l);
        }
    }

    public static void quickSort(int[] nums, int st, int end){
        if (st >= end) return;

        int pivot = getPivot(nums, st, end);
        quickSort(nums, st, pivot-1);
        quickSort(nums, pivot+1, end);
    }

    public static int getPivot(int[] nums, int st, int end){
        int pivot = st;

        int i = st, j = end;

        while (i < j){
            while (i <= end && nums[i] <= nums[pivot]){
                i+=1;
            }

            while (j > st && nums[j] >= nums[pivot]){
                j-=1;
            }

            if (i < j){
                swap(nums, i, j);
            }
        }
        swap(nums, st, j);
        return pivot;
    }

    public static int removeDuplicatesBrute(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int index = 0;

        for(int num: set){
            nums[index] = num;
            index+=1;
        }

        return index;
    }

    // {1, 1, 2, 2, 3, 3}
    public static int removeDuplicatesOp(int[] nums){
        int i = 0;

        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                nums[i+1] = nums[j];
                i+=1;
            }
        }
        return i+1;
    }

    // {1, 2, 3, 4, 5}
    // {3, 4, 5, 1, 2}
    public static void leftRotateArrayByKPlaces(int[] nums, int k){
        k = k % nums.length;

        int[] temp = new int[k];

        for (int i = 0; i < k; i++){
            temp[i] = nums[i];
        }

        for (int j = k; j < nums.length; j++){
            nums[j - k] = nums[j];
        }

        int index = 0;
        for (int l = nums.length - k; l < nums.length; l++){
            nums[l] = temp[index];
            index+=1;
        }
    }

    public static void moveZerosToEndBrute(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();

        for (int num: nums){
            if (num != 0) list.add(num);
        }

        for (int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }

        for (int i = list.size(); i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void moveZerosToEndOp(int[] nums){
        int i = 0;

        for (int j = 0; j < nums.length; j++){
            if (nums[j] == 0){
                i = j;
                break;
            }
        }

        //{1, 2, 0, 0, 3, 0, 4, 0, 5}
        for (int k = i + 1; k < nums.length; k++){
            if (nums[k] != 0){
                swap(nums, k, i);
                i+=1;
            }
        }
    }

    // {1, 2, 3, 3, 5}
    // {2, 2, 4}
    public static ArrayList<Integer> unionOfTwoSortedArrays(int[] nums1, int[] nums2){
        ArrayList<Integer> union = new ArrayList<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] <= nums2[j]){
                if (!union.contains(nums1[i])){
                    union.add(nums1[i]);
                }
                i+=1;
            }
            else {
                if (!union.contains(nums2[j])){
                    union.add(nums2[j]);
                }
                j+=1;
            }
        }

        while (i < nums1.length){
            if (!union.contains(nums1[i])){
                union.add(nums1[i]);
            }
            i+=1;
        }

        while (j < nums2.length){
            if (!union.contains(nums2[j])){
                union.add(nums2[j]);
            }
            j+=1;
        }
        return union;
    }

    // {1, 3, 4, 5}
    public static int findMissingNumberBrute(int[] nums){
        boolean[] hash = new boolean[nums.length+2];

        for (int num: nums){
            hash[num] = true;
        }

        for (int i = 1; i < hash.length; i++){
            if (!hash[i]) return i;
        }
        return -1;
    }

    public static int findMissingNumberOp(int[] nums){
        int n = nums[nums.length - 1];
        int sum1 = n * (n+1)/2;

        int sum2 = 0;

        for (int num: nums){
            sum2 += num;
        }

        return sum1 - sum2;
    }

    // {0, 1, 0, 1, 1, 1, 0, 1, 1}
    public static int maxConsecutiveOnes(int[] nums){
        int maxCount = 0;

        int count = 0;

        for (int num: nums){
            if (num == 1){
                count +=1;
            } else {
                maxCount = Integer.max(count, maxCount);
                count = 0;
            }
        }
        maxCount = Integer.max(count, maxCount);
        return maxCount;
    }

    // {1, 2, 2, 3, 3, 4, 4}
    public static int findNumberAppearsOnceAndOthersTwiceOp(int[] nums){
        int res = 0;

        for (int num: nums){
            res ^= num;
        }
        return res;
    }

    public static int noOfSubarraysEqual0Op(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for (int num: nums){
            prefixSum += num;

            if (map.containsKey(prefixSum)){
                count+=1;
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }

    public static void sortArrayOf0s1sand2sOp(int[] nums){
        int l = 0;
        int m = 0;
        int h = nums.length-1;

        while (m <= h){
            if (nums[m] == 0){
                swap(nums, l, m);
                l+=1;
                m+=1;
            } else if (nums[m] == 2){
                swap(nums, m, h);
                h-=1;
            } else {
                m+=1;
            }
        }
    }

    public static int[] twoSumOp(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = {-1, -1};

        for (int num: nums){
            if (map.containsKey(k - num)){
                ans[0] = num;
                ans[1] = k - num;
            } else {
                map.put(num, 0);
            }
        }
        return ans;
    }

    public static int stockBuySellBrute(int[] nums){
        int maxProfit = 0;

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                int profit = nums[j] - nums[i];
                maxProfit = Integer.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static int stockBuySellOp(int[] nums){
        int bought = nums[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++){
            maxProfit = Integer.max(maxProfit, nums[i] - bought);
            if (nums[i] < bought){
                bought = nums[i];
            }
        }
        return maxProfit;
    }

    public static void rearrangeArrayElementsBySign(int[] nums){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int num: nums){
            if (num < 0) neg.add(num);
            else pos.add(num);
        }

        for (int i = 0; i < (nums.length)/2; i++){
            nums[i * 2] = pos.get(i);
            nums[i * 2 + 1] = neg.get(i);
        }
    }

    public static int[] rearrangeArrayElementsBySignOp(int[] nums){
        int i = 0, j = 1;
        int[] ans = new int[nums.length];

        for (int num: nums){
            if (num < 0){
                ans[j] = num;
                j+=2;
            } else {
                ans[i] = num;
                i+=2;
            }
        }
        return ans;
    }

    public static int countSubarraysWithGivenSumKOp(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num: nums){
            prefixSum += num;

            if (map.containsKey(prefixSum - k)){
                count += 1;
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }

    public static int kadanesAlgo(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int prefixSum = 0;

        for (int num: nums){
            prefixSum += num;

            maxSum = Integer.max(maxSum, prefixSum);

            if (prefixSum < 0){
                prefixSum = 0;
            }
        }
        return maxSum;
    }

    public static int lowerBound(int[] nums, int k){
        int l = 0, h = nums.length - 1;

        while (l <= h){
            int m = (l + h)/2;

            if (nums[m] == k) return m;

            if (nums[m] > k){
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static int floor(int[] nums, int k){
        int l = 0, h = nums.length - 1;

        while (l <= h){
            int m = (l+h)/2;

            if (nums[m] == k) return nums[m];

            if (nums[m] < k){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return nums[h];
    }

    public static int ceil(int[] nums, int k){
        int l = 0, h = nums.length - 1;

        while (l <= h){
            int m = (l+h)/2;

            if (nums[m] == k) return nums[m];

            if (nums[m] < k){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return nums[l];
    }

    public static int searchInRotatedSortedArray1(int[] nums, int k){
        int l = 0, h = nums.length - 1;

        while (l <= h){
            int m = (l + h) / 2;

            if (nums[m] == k) return m;

            if (nums[l] <= nums[m]){
                if (k >= nums[l] && k < nums[m]){
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (k > nums[m] && k <= nums[h]){
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }

    public static int findMinRotatedSortedArray(int[] nums){
        int minimum = Integer.MAX_VALUE;
        int l = 0, h = nums.length-1;

        while (l <= h){
            int m = (l + h) / 2;

            if (nums[l] <= nums[m]){
                minimum = Integer.min(nums[l], minimum);
                l = m + 1;
            } else {
                minimum = Integer.min(nums[m], minimum);
                h = m - 1;
            }
        }
        return minimum;
    }

    public static int findOutHowManyTimesArrayHasBeenRotated(int[] nums){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        int l = 0, h = nums.length - 1;

        while (l <= h){
            int m = (l + h)/2;

            if (nums[l] <= nums[m]){
                if (nums[l] < min){
                    min = nums[l];
                    minIndex = l;
                }
                l = m + 1;
            } else {
                if (nums[m] < min){
                    min = nums[m];
                    minIndex = m;
                }
                h = m - 1;
            }
        }
        return minIndex;
    }

    public static int singleElementInSortedArray(int[] nums){
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length-1] != nums[nums.length - 2]) return nums[nums.length - 1];

        int l = 1, h = nums.length - 2;

        while (l <= h){
            int m = (l + h)/2;
            if (nums[m] != nums[m-1] && nums[m] != nums[m+1]) return nums[m];

            if (m % 2 == 0 && nums[m] == nums[m+1] ||
                    m % 2 == 1 && nums[m] == nums[m-1]){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    public static int findPeak(int[] nums){
        if (nums[0] > nums[1]) return nums[0];
        if (nums[nums.length-1] > nums[nums.length-2]) return nums[nums.length-1];

        int l = 1, h = nums.length-2;

        while (l <= h){
            int m = (l+h)/2;

            if (nums[m] > nums[m-1] && nums[m] > nums[m+1]){
                return nums[m];
            } else if (nums[m] < nums[m+1]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    public static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int num: nums){
            max = Integer.max(max, num);
        }
        return max;
    }

    public static int sumOfAllNums(int[] nums){
        int sum = 0;

        for (int num: nums){
            sum += num;
        }
        return sum;
    }

    public static int bookAllocationProblem(int[] nums, int k){
        int l = findMax(nums);
        int h = sumOfAllNums(nums);

        while (l <= h){
            int m = (l+h)/2;

            if (isValidCapacity(nums, m, k)){
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean isValidCapacity(int[] nums, int capacity, int k){
        int sumOfPages = 0;
        int count = 1;

        for (int num: nums){
            sumOfPages += num;

            if (sumOfPages > capacity){
                count += 1;
                sumOfPages = num;
            }
        }
        return count <= k;
    }

    public static int shipPackagesWithinDDays(int[] weights, int days){
        int l = findMax(weights);
        int h = sumOfAllNums(weights);

        while (l <= h){
            int m = (l + h)/2;

            if (isValidShip(weights, m, days)){
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean isValidShip(int[] weights, int capacity, int days){
        int count = 1;
        int sum = 0;

        for (int num: weights){
            sum += num;

            if (sum > capacity){
                count += 1;
                sum = num;
            }
        }
        return count <= days;
    }

    /*
     * The main idea in Painter Partition Problem is also regarding capacity, similar to
     * Book Allocation Problem and Ship Packages Within Days, where we had to find the,
     * min capacity of each student at which all the books could be distributed among k students
     * min capacity of ship required at which all the weight could be transported in d days
     * Similarly here, we have to find the min units for each painter, where k painters can paint all
     * the boards.
     * */
    public static int painterPartitionProblem(int[] boards, int k){
        int l = findMax(boards);
        int h = sumOfAllNums(boards);

        while (l <= h){
            int m = (l + h)/2;

            if (isValidUnits(boards, m, k)){
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean isValidUnits(int[] boards, int units, int k){
        int count = 1;
        int sum = 0;

        for (int num: boards){
            sum += num;

            if (sum > units){
                count += 1;
                sum = num;
            }
        }

        return count <= k;
    }

    public static int splitArrayLargestSum(int[] arr, int k){
        int l = findMax(arr);
        int h = sumOfAllNums(arr);

        while (l <= h){
            int m = (l + h)/2;

            if (isValidUnits(arr, m, k)){
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static int aggressiveCows(int[] stalls, int k){
        Arrays.sort(stalls);
        int l = 1, h = stalls[stalls.length-1] - stalls[0];

        while (l <= h){
            int m = (l+h)/2;

            if (isValidSpace(stalls, m, k)){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }

    public static boolean isValidSpace(int[] stalls, int space, int k){
        int count = 1;
        int currentStall = stalls[0];

        for (int i = 1; i < stalls.length; i++){
            if (stalls[i] - currentStall >= space){
                count += 1;
                currentStall = stalls[i];
            }
        }
        return count >= k;
    }

    public static int kokoEatingBananas(int[] arr, int hrs){
        int l = 1, h = findMax(arr);

        while (l <= h){
            int m = (l + h)/2;

            if (canFinishWithMBananas(arr, m, hrs)){
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static boolean canFinishWithMBananas(int[] arr, int m, int hrs){
        int totalHrs = 0;

        for (int num: arr){
            totalHrs += Math.ceilDiv(num,m);
        }
        return totalHrs <= hrs;
    }

    public static int nthRootOfM(int n, int m){
        int l = 1, h = m;

        while (l <= h){
            int mid = (l+h)/2;

            int xPowN = xPowN(mid, n);

            if (xPowN == m){
                return mid;
            }
            if (xPowN > m){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int xPowN(int x, int n){
        int ans = 1;

        for (int i = 0; i < n; i++){
            ans *= x;
        }
        return ans;
    }

    public static int[] binarySearchOn2DArray(int[][] nums, int target){
        int low = 0, high = nums.length * nums[0].length - 1;
        int[] ans = {-1, -1};
        while (low <= high){
            int mid = (low + high)/2;

            int row = mid/nums[0].length;
            int col = mid%nums[0].length;

            if (nums[row][col] == target) {
                ans[0] = row;
                ans[1] = col;
            }

            if (nums[row][col] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}