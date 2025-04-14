public class ConsecutvieOnes {
    public static void main(String[] args) {
        consecutiveOnes();
    }

    public static void consecutiveOnes(){
        int [] nums = {1,0,1,1,0,1};
        int onesCount = 0;

        int maxNoOfOnes = 0;

        for (int num: nums){
            if (num == 1){
                onesCount++;
                if (onesCount > maxNoOfOnes){
                    maxNoOfOnes = onesCount;
                }
            } else {
                onesCount = 0;
            }
        }

        System.out.println(maxNoOfOnes);
    }
}
