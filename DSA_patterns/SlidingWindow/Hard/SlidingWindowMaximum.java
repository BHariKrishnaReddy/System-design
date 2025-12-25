package DSA_patterns.SlidingWindow.Hard;

/*
For every contiguous subarray (window) of size K, find the maximum element.
*/

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>(); // stores indexes
        int idx = 0;

        for (int right = 0; right < n; right++) {

            // Remove indexes that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // Maintain decreasing order in deque
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[right]) {
                deque.pollLast();
            }

            // Add current index
            deque.addLast(right);

            // Start recording answers once the first window is complete
            if (right >= k - 1) {
                result[idx++] = arr[deque.peekFirst()];
            }
        }

        return result;
    }
}
