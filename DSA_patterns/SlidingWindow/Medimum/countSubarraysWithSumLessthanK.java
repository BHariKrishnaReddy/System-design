package DSA_patterns.SlidingWindow.Medimum;

public class countSubarraysWithSumLessthanK {

    public int countSubarrays(int[] arr, int k) {
        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < arr.length; right++) {

            // expand window
            sum += arr[right];

            // shrink window if invalid
            while (sum >= k) {
                sum -= arr[left];
                left++;
            }

            // count valid subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        countSubarraysWithSumLessthanK sol =
                new countSubarraysWithSumLessthanK();

        System.out.println(sol.countSubarrays(new int[]{2, 1, 3}, 4)); // 4
    }
}
