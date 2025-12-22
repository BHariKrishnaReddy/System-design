package DSA_patterns.SlidingWindow.Medimum;
import java.util.HashMap;
import java.util.Map;

public class CountSubarraysNoElementMoreThanTwice {

    public int countSubarrays(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < arr.length; right++) {

            // expand window
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            // shrink window if invalid
            while (freq.get(arr[right]) > 2) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) {
                    freq.remove(arr[left]);
                }
                left++;
            }

            // count valid subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubarraysNoElementMoreThanTwice sol =
                new CountSubarraysNoElementMoreThanTwice();

        System.out.println(sol.countSubarrays(new int[]{1, 2, 1, 1})); // 8
    }
}

