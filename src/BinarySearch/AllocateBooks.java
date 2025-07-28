package BinarySearch;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        int m = 2;
//        int ans = allocateBooksBrute(nums, m);
        int ans=distributeBooksOp(nums,m);
        System.out.println(ans);
    }

    static int allocateBooksBrute(int[] books, int m){
        int n = books.length;
//        Taking min the last elem, because as the array is sorted I will get the book with max pages.
//        Starting min from max no of pages because
        /* If we start from min pages, then we are telling that a student can hold a book with only that
        * many pages.
        * This way we will only be able to give 1 book with min pages to one student, this violates the
        * constraint which asks us assign at least one book to every student.
        *
        * Now if we start from a student can hold max pages, then we will be able to assign a book to every
        * student.
        * EX: [25, 46, 28, 49, 24], students=4
        * Every student can hold upto 49 pages
        * 1st student we give 25 pages, he says he can hold upto 49 so we add another set which is 46 but 46+25 = 71
        * Hence we give him only 25 pages, and move to next student and also we pick the cur pages which is 46.
        * 2nd student we check
        * */
        int min = findMax(books), max = sumOfAllPages(books);

        for (int i = min; i <= max; i++){
            int students = allotPagesToStudents(books, i);
            if (students == m) return i;
        }
        return -1;
    }

    static int distributeBooksOp(int[] books, int m){
        int low=findMax(books), high=sumOfAllPages(books);

        while (low<=high){
            int mid = (low+high)/2;
            int ans = validPages(books, mid);
            if (ans <= m){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return low;
    }

    static int validPages(int[] books, int pages){
        int n=books.length;
        int students=1;
        int studentPages=0;
        for (int i = 0; i < n; i++){
            if (studentPages+books[i] > pages){
                students++;
                studentPages=books[i];
            } else {
                studentPages+=books[i];
            }
        }
        return students;
    }

    static int allotPagesToStudents(int[] nums, int pages){
        int n = nums.length;
        int students = 1;
        int noOfPages = 0;
        for (int i = 0; i < n; i++){
            if (noOfPages + nums[i] <= pages){
                noOfPages+=nums[i];
            } else {
                students++;
                noOfPages=nums[i];
            }
        }
        return students;
    }

    static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int num: nums){
            max = Math.max(num,max);
        }
        return max;
    }

    static int sumOfAllPages(int[] nums){
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        return sum;
    }
}
