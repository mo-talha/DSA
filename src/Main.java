import java.util.*;

class LinkedList{
    int value;
    LinkedList next;

    public LinkedList(int value, LinkedList node){
        this.value = value;
        this.next = node;
    }

    public LinkedList(){
        this.value = 0;
        this.next = null;
    }

    public LinkedList createLinkedList(int[] nums){
        LinkedList head = new LinkedList(nums[0], null);
        LinkedList temp = head;

        for (int i = 1; i < nums.length; i++){
            LinkedList node = new LinkedList(nums[i], null);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public void printLinkedList(LinkedList head){
        LinkedList temp = head;

        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public LinkedList getTail(LinkedList head){
        LinkedList temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }
}

public class Main{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<String> RAT_IN_A_MAZE_RESULT = new ArrayList<>();
    static ArrayList<ArrayList<String>> FINAL_BOARD_WITH_N_QUEENS = new ArrayList<>();

    public static void main(String[] args){
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };
//        sudokuSolver(board, 0, 0);
//        System.out.println(Arrays.deepToString(board));
//        String ans = removeOutermostParenthesis("(()())");
//        System.out.println(ans);

//        String ans = sortCharactersByFrequency("queen");
//        System.out.println(ans);
        int ans = maxNestingDepthOfParenthesis("()(())((()()))");
        System.out.println(ans);
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

    public static int findSmallestDivisor(int[] nums, int threshold){
        int low = 1, high = findMax(nums);

        while (low <= high){
            int mid = (low + high)/2;

            if (isDivisor(nums, mid, threshold)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isDivisor(int[] nums, int x, int threshold){
        int sum = 0;

        for (int num: nums){
            sum += Math.ceilDiv(num, x);
        }
        return sum <= threshold;
    }

    public static int reverseNumber(int num){
        int reverse = 0;
        int x = num;
        while (x != 0){
            reverse = reverse * 10 + x % 10;
            x = x/10;
        }
        return reverse;
    }

    /* Linked List */
    public static LinkedList deleteKthNode(LinkedList head, int k){
        LinkedList temp = head;
        int count = 0;
        LinkedList prev = null;

        if (k == 1) {
            head = head.next;
            return head;
        }

        while (temp != null){
            count += 1;

            if (count == k){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static LinkedList reverseLinkedListRecursively(LinkedList head){
        if (head == null || head.next == null){
            return head;
        }

        LinkedList newHead = reverseLinkedListRecursively(head.next);

        LinkedList front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static LinkedList findStartingPoint(LinkedList head){
        LinkedList slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static int getLenOfLoop(LinkedList head){
        LinkedList slow = head, fast = head;
        int count = 0;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = slow.next;

                while (slow != fast){
                    slow = slow.next;
                    count +=1;
                }
                break;
            }
        }
        return count;
    }

    public static LinkedList mergeTwoSortedLinkedLists(LinkedList head1, LinkedList head2){
        LinkedList dummyHead = new LinkedList(-1, null);
        LinkedList temp = dummyHead;
        LinkedList temp1 = head1;
        LinkedList temp2 = head2;

        while (temp1 != null && temp2 != null){
            if (temp1.value <= temp2.value){
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        if (temp1 != null) temp.next = temp1;
        if (temp2 != null) temp.next = temp2;

        return dummyHead.next;
    }

    public static LinkedList getMid1(LinkedList head){
        LinkedList slow = head;
        LinkedList fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static LinkedList mergeSortLinkedList(LinkedList head){
        if (head == null || head.next == null) return head;

        LinkedList mid =getMid1(head);
        LinkedList leftHead = head;
        LinkedList rightHead = mid.next;
        mid.next = null;

        leftHead = mergeSortLinkedList(leftHead);
        rightHead = mergeSortLinkedList(rightHead);
        return mergeTwoSortedLinkedLists(leftHead, rightHead);
    }

    public static LinkedList removeDuplicates(LinkedList head){
        HashSet<Integer> set = new HashSet<>();
        LinkedList temp = head;

        while (temp != null){
            set.add(temp.value);
            temp = temp.next;
        }

        temp = head;
        for (Integer num: set){
            temp.value = num;
            temp = temp.next;
        }

        int index = set.size();
        temp = head;
        while (temp != null){
            index--;
            if (index == 0){
                temp.next = null;
            }
            temp = temp.next;
        }
        return head;
    }

    // {2, 2, 2, 3, 3, 4, 4, 4, 5, 5}
    public static LinkedList removeDuplicatesOp1(LinkedList head){
        LinkedList prev = head;
        LinkedList current = head.next;

        while (current != null){
            if (current.value == prev.value){
                prev.next = current.next;
                current = prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

//    int[] nums1 =   {2,4,9};
//    int[] nums2 = {5,6,4,9};
    public static LinkedList addTwoNumbers(LinkedList head1, LinkedList head2){
        int carry = 0;
//        LinkedList reversedHead1 = reverseLinkedListRecursively(head1);
//        LinkedList reversedHead2 = reverseLinkedListRecursively(head2);
        LinkedList dummyHead = new LinkedList(-1, null);
        LinkedList temp = dummyHead;
//        LinkedList temp1 = reversedHead1, temp2 = reversedHead2;
        LinkedList temp1 = head1, temp2 = head2;
        int sum = 0;
        while (temp1 != null && temp2 != null){
            sum = temp1.value + temp2.value + carry;
            carry = sum/10;
            temp.next = new LinkedList(sum % 10, null);
            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null){
            sum = temp1.value + carry;
            carry = sum/10;
            temp.next = new LinkedList(sum % 10, null);
            temp = temp.next;
            temp1 = temp1.next;
        }

        while (temp2 != null){
            sum = temp2.value + carry;
            carry = sum/10;
            temp.next = new LinkedList(sum % 10, null);
            temp = temp.next;
            temp2 = temp2.next;
        }

        while (carry != 0){
            temp.next = new LinkedList(carry % 10, null);
            carry /= 10;
        }

        return reverseLinkedListRecursively(dummyHead.next);
    }

    public static LinkedList addOneNumber(LinkedList head){
        LinkedList revHead = reverseLinkedListRecursively(head);

        LinkedList temp = revHead;
        int carry = 1;
        int sum;
        while (temp != null && carry > 0){
            sum = temp.value + carry;
            temp.value = sum % 10;
            carry = sum/10;

            if (temp.next == null && carry > 0){
                temp.next = new LinkedList(carry, null);
                carry = 0;
            }
            temp=temp.next;
        }

        return reverseLinkedListRecursively(revHead);
    }

    public static LinkedList addOneNumberOpMain(LinkedList head){
        int carry = addOneNumberOp(head);
        if (carry > 0){
            return new LinkedList(carry, head);
        }
        return head;
    }

    public static int addOneNumberOp(LinkedList head){
        if (head == null){
            return 1;
        }
        int carry = addOneNumberOp(head.next);
        int sum = head.value + carry;
        head.value = sum % 10;
        carry = sum/10;
        return carry;
    }

    public static LinkedList intersectionOfTwoLinkedListsOp(LinkedList head1, LinkedList head2){
        LinkedList temp1 = head1, temp2 = head2;

        while (temp1 != temp2){
            temp1 = temp1 == null ? head2 : temp1.next;
            temp2 = temp2 == null ? head1 : temp2.next;
        }
        return temp1;
    }

//    Recursion
    public static double xPowNRec(int x, int n){
        if (n == 0){
            return 1;
        }
        return x * xPowN(x, n-1);
    }

    public static int xPowNRecOp(int x, int n){
        if (n == 0){
            return 1;
        }
        int xn = xPowNRecOp(x, n/2);
        int xPowN = xn * xn;
        if (n%2 == 1) return x * xPowN;
        return xPowN;
    }

    public static int xPowNWithNegPowers(int x, int n){
        int xPowN = xPowNRecOp(x, Math.abs(n));

        return n < 0 ? 1/xPowN : xPowN;
    }

    public static void sortAStackRecursively(Stack<Integer> st){
        if (st.isEmpty()){
            return;
        }
        int peek = st.pop();
        sortAStackRecursively(st);

        insertAtRightPosition(st, peek);
    }

    public static void insertAtRightPosition(Stack<Integer> st, int num){
        if (st.isEmpty() || num > st.peek()){
            st.push(num);
            return;
        }
        int top = st.pop();
        insertAtRightPosition(st, num);
        st.push(top);
    }

    public static void reverseAStack(Stack<Integer> st){
        if (st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverseAStack(st);
        insertAtBottom(st, top);
    }

    public static void insertAtBottom(Stack<Integer> st, int num){
        if (st.isEmpty()){
            st.push(num);
            return;
        }
        int peek = st.pop();
        insertAtBottom(st, num);
        st.push(peek);
    }

    // Backtracking
//    public static void generateBinaryStringsOfSizeN(int n, StringBuilder temp){
//        if (temp.length() == n){
//            res.add(temp.toString());
//            return;
//        }
//        temp.append("0");
//        generateBinaryStringsOfSizeN(n, temp);
//        temp.deleteCharAt(temp.length() - 1);
//
//        if (temp.isEmpty() || temp.charAt(temp.length()-1) != '1'){
//            temp.append("1");
//            generateBinaryStringsOfSizeN(n, temp);
//            temp.deleteCharAt(temp.length() - 1);
//        }
//    }
//
//    public static void generateParenthesis(int n, StringBuilder temp, int open, int close){
//        if (temp.length() == n * 2){
//            res.add(temp.toString());
//            return;
//        }
//        if (open < n){
//            temp.append("(");
//            generateParenthesis(n, temp, open+1, close);
//            temp.deleteCharAt(temp.length()-1);
//        }
//
//        if (close < open){
//            temp.append(")");
//            generateParenthesis(n, temp, open, close + 1);
//            temp.deleteCharAt(temp.length() - 1);
//        }
//    }

    public static void generatePowerSets(int n, int i, ArrayList<Integer> temp, int[] nums){
        if (i == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        generatePowerSets(n, i + 1, temp, nums);
        temp.removeLast();

        generatePowerSets(n, i + 1, temp, nums);
    }

    public static void subsequenceEqualsKOp(int k, int[] nums, int i, int sum, ArrayList<Integer> temp){
        if (sum == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if (i >= nums.length || sum > k){
            return;
        }
        temp.add(nums[i]);
        subsequenceEqualsKOp(k, nums, i+1, sum + nums[i], temp);
        temp.removeLast();

        subsequenceEqualsKOp(k, nums, i+1, sum, temp);
     }

     public static void combinationSum1(int k, int[] nums, int i, int sum, ArrayList<Integer> temp){
        if (sum == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if (i >= nums.length || sum > k){
            return;
        }
        temp.add(nums[i]);
        combinationSum1(k, nums, i, sum+nums[i], temp);

        temp.removeLast();

        combinationSum1(k, nums, i+1, sum, temp);
     }

     public static void printSumOfSubsets(int[] nums, int i, int sum){
        if (i >= nums.length){
            System.out.println(sum);
            return;
        }
        printSumOfSubsets(nums, i + 1, sum+nums[i]);

        printSumOfSubsets(nums, i+1, sum);
     }

     public static ArrayList<String> letterCombinations(String digits, int index, HashMap<Character, String> phoneBook, StringBuilder temp, ArrayList<String> res){
        if (index == digits.length()){
            res.add(temp.toString());
            return res;
        }
        Character digit = digits.charAt(index);
        String letters = phoneBook.get(digit);

        for (char ch: letters.toCharArray()){
            temp.append(ch);
            res = letterCombinations(digits, index + 1, phoneBook, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }
        return res;
     }

     public static boolean wordSearch(char[][] board, String word){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (backtrackWordSearch(board, word, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
     }

     public static boolean backtrackWordSearch(char[][] board, String word, int index, int i, int j){
        if (index >= word.length()){
            return true;
        }

        if (i < 0 || i >= board.length ||
                j < 0 || j > board[0].length ||
                board[i][j] == '#' ||
                board[i][j] != word.charAt(index)
        ){
            return false;
        }
        boolean res;
        char temp = board[i][j];
        board[i][j] = '#';

//        up
         res = backtrackWordSearch(board, word, index+1, i-1, j) ||

//        down
         backtrackWordSearch(board, word, index+1, i+1, j) ||

//         left
         backtrackWordSearch(board, word, index+1, i, j-1) ||

//         right
         backtrackWordSearch(board, word, index+1, i, j+1);

         board[i][j] = temp;

         return res;
     }

     public static void ratInAMaze(){
        int[][] board = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        backtrackRatInAMaze(board, 0, 0, new StringBuilder());
     }

     public static void backtrackRatInAMaze(int[][] board, int i, int j, StringBuilder path){
        if (i >= board.length-1 && j >= board[0].length-1){
            RAT_IN_A_MAZE_RESULT.add(path.toString());
            return;
        }
        if (
                i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length ||
                        board[i][j] == 0|| board[i][j] == -1
        )
            return;

        int temp = board[i][j];
        board[i][j] = -1;

        // Move up
         backtrackRatInAMaze(board, i-1, j, path.append("U"));
         path.deleteCharAt(path.length()-1);

         // Move down
         backtrackRatInAMaze(board, i+1, j, path.append("D"));
         path.deleteCharAt(path.length()-1);

         // Move left
         backtrackRatInAMaze(board, i, j-1, path.append("L"));
         path.deleteCharAt(path.length()-1);

         // Move right
         backtrackRatInAMaze(board, i, j+1, path.append("R"));
         path.deleteCharAt(path.length()-1);

         board[i][j] = temp;
     }

     // weekly contest 499
     public static List<Integer> findValidElements(int[] nums) {
         List<Integer> res = new ArrayList<>();

         for (int i = 0; i < nums.length; i++){
             if (i == 0 || i == nums.length-1) res.add(nums[i]);
             else if (checkLeft(nums, i) || checkRight(nums, i)){
                 res.add(nums[i]);
             }
         }
         return res;
     }

    public static boolean checkLeft(int[] nums, int target){
        for (int i = 0; i < target; i++){
            if (nums[i] > nums[target]) return false;
            if (nums[i] == nums[target]) return false;
        }
        return true;
    }

    public static boolean checkRight(int[] nums, int target){
        for (int i = nums.length-1; i > target; i--){
            if (nums[i] > nums[target]) return false;

            if (nums[i] == nums[target]) return false;
        }
        return true;
    }

    public static String sortVowels(String s){
        HashMap<Character, Integer> countOfVowels = new HashMap<>();
        countOfVowels.put('a', 0);
        countOfVowels.put('e', 0);
        countOfVowels.put('i', 0);
        countOfVowels.put('o', 0);
        countOfVowels.put('u', 0);

        for (char ch: s.toCharArray()){
            if (countOfVowels.containsKey(ch)){
                countOfVowels.put(ch, countOfVowels.get(ch)+1);
            }
        }
        StringBuilder res = new StringBuilder();
        // leetcode
        for (char ch: s.toCharArray()){
            if (countOfVowels.containsKey(ch)){
                char nonZeroChar = getMaxVowel(countOfVowels);
                res.append(nonZeroChar);
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    public static char getMaxVowel(HashMap<Character, Integer> vowels){
        char nonZeroChar = '0';

        for (Map.Entry<Character, Integer> entry: vowels.entrySet()){
            if (entry.getValue() > 0){
                nonZeroChar = entry.getKey();
                break;
            }
        }
        vowels.put(nonZeroChar, vowels.get(nonZeroChar)-1);
        return nonZeroChar;
    }

    public static void place(char[][] board, boolean[] columns, int n, int row){
        if (row >= n){
            FINAL_BOARD_WITH_N_QUEENS.add(construct(board));
            return;
        }

        for (int j = 0; j < board[0].length; j++){
            if (!columns[j] && checkDiags(board, row, j)){
                columns[j] = true;
                board[row][j] = 'Q';
                place(board, columns, n, row+1);
                board[row][j] = '.';
                columns[j] = false;
            }
        }
    }

    public static boolean checkDiags(char[][] board, int row, int col){
       int i = row, j = col;

       // checking upper left dia
        while (i >= 0 && j >= 0){
            if (board[i][j] == 'Q') return false;
            i-=1;
            j-=1;
        }

        // checking upper right dia
        i=row; j=col;
        while (i >= 0 && j <= board[0].length-1){
            if (board[i][j] == 'Q') return false;
            i-=1;
            j+=1;
        }
        return true;
    }

    public static ArrayList<String> construct(char[][] board){
        ArrayList<String> res = new ArrayList<>();

        for (char[] arr: board){
            res.add(Arrays.toString(arr));
        }
        return res;
    }

    public static boolean sudokuSolver(char[][] board, int i, int j){
        if (i >= 9) return true;
        if (j >= 9) return sudokuSolver(board, i+1, 0);
        if (board[i][j] != '.') return sudokuSolver(board, i, j+1);

        for (int num = 1; num <= 9; num++){
            if (check(board, num, i, j)){
                char c = (char) ('0' + num);
                board[i][j] = c;

                if (sudokuSolver(board, i, j + 1)){
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    public static boolean check(char[][] board, int num, int row, int col){
        char numChar = (char) ('0' + num);
        // checking if num exists in row
        for (int i = 0; i < 9; i++){
            if (board[row][i] == numChar) return false;
        }

        // checking if num exists in col
        for (int j = 0; j < 9; j++){
            if (board[j][col] == numChar) return false;
        }

        // checking the grid
        int a = (row/3) * 3, b = (col/3) * 3;

        for (int i = a; i < a+3; i++){
            for (int j = b; j < b+3; j++){
                if (board[i][j] == numChar) return false;
            }
        }
        return true;
    }

    // String questions
    public static String removeOutermostParenthesis(String s){
        StringBuilder temp = new StringBuilder();
        int count = 0;
        for (char ch: s.toCharArray()){
            if (ch == '('){
                if (count > 0){
                    temp.append(ch);
                }
                count+=1;
            } else {
                count-=1;
                if (count > 0){
                    temp.append(ch);
                }
            }
        }
        return temp.toString();
    }

    public static boolean palindromeCheck(String s){
        int i = 0, j = s.length()-1;

        while (i <= j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i+=1;
            j-=1;
        }
        return true;
    }

    public static String largestOddNumber(String s){
        for (int i = s.length()-1; i >= 0; i--){
            int num = s.charAt(i) - '0';
            if (num % 2 == 1){
                return s.substring(0, i+1);
            }
        }
        return "";
    }

    public static String sortCharactersByFrequency(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        // O(N)
        for (char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        System.out.println(map);
        int maxFreq = Integer.MIN_VALUE;
        // O(N)
        for (int value: map.values()){
            maxFreq = Integer.max(maxFreq, value);
        }

        // O(MAX_FREQ)
        ArrayList<ArrayList<Character>> buckets = new ArrayList<>();
        for (int i = 1; i <= maxFreq+1; i++){
            buckets.add(new ArrayList<>());
        }

        System.out.println(buckets);
        // O(N)
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            buckets.get(value).add(key);
        }

        // O(MAX_FREQ)
        StringBuilder ans = new StringBuilder();
        for (int i = maxFreq; i >= 1; i--){
            ArrayList<Character> bucket = buckets.get(i);

            for (char ch: bucket){
                ans.repeat(ch, i);
            }
        }

        System.out.println(buckets);
        return ans.toString();
    }

    public static int maxNestingDepthOfParenthesis(String s){
        int maxCount = Integer.MIN_VALUE;
        int count = 0;

        for (char ch: s.toCharArray()){
            if (ch == '('){
                count+=1;
            } else if (ch == ')'){
                maxCount = Integer.max(maxCount, count);
                count-=1;
            }
        }
        return maxCount;
    }
}