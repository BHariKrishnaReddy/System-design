package DSA_patterns.SlidingWindow.Easy;

public class CountSubarraysWhereNumberofOddElementsisLessThanK {

    public int validSubArrays(int[] A, int k){
        int left=0;
        int subArrayConuter = 0;
        int oddCounter =0;

        for(int right =0;right < A.length;right++){
            //Expanding
            if(A[right]%2!=0){
                oddCounter++;
            }

            //shrink
            while(oddCounter >=k){
                if(A[left]%2!=0){
                    oddCounter--;
                }
                left++;
            }
            subArrayConuter += (right - left+1); // R - L + 1 is the number of valid subarrays that END at index R, given that the window [L … R] is valid.

        }
        return subArrayConuter;
    }

    public static void main(String[] args) {
        CountSubarraysWhereNumberofOddElementsisLessThanK sol =
                new CountSubarraysWhereNumberofOddElementsisLessThanK();

        int[] arr = {2, 1, 3, 4};
        int k = 2;

        System.out.println(sol.validSubArrays(arr, k)); // Output: 6
    }
    
}
