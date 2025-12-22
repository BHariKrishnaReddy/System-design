package DSA_patterns.SlidingWindow.Medimum;
/*
Is there at least one contiguous subarray of length 2 or more that contains a duplicate element?

>> If an element repeats inside a contiguous window, a duplicate subarray exists — return immediately.

Pattern Recognition Tip
When you see:
    “check if any subarray…”
    “duplicate elements”
    “contiguous”
Your brain should jump to:
    Sliding Window + Set


*/

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicateSubarray {

    public boolean hasDuplicateSubarray(int[] arr) {
        Set<Integer> window = new HashSet<>();
        int left = 0;

        for (int right = 0; right < arr.length; right++) {

            // If element already exists in window, duplicate found
            if (window.contains(arr[right])) {
                return true;
            }

            window.add(arr[right]);

            // Ensure window length is at least 2
            if (right - left + 1 > 1) {
                // nothing else required, condition already checked
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CheckDuplicateSubarray sol = new CheckDuplicateSubarray();
        System.out.println(sol.hasDuplicateSubarray(new int[]{1, 2, 3, 1})); // true
        System.out.println(sol.hasDuplicateSubarray(new int[]{1, 2, 3, 4})); // false
    }
}

