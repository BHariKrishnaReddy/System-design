package DSA_patterns.SlidingWindow.Medimum;

/*
You’re given an array of “category labels” (strings/ints). You must find the smallest contiguous subarray that contains at least one occurrence of every category that exists anywhere in the array.
Example:
labels = [A, B, A, C, B, A]
Distinct categories are {A, B, C}.
Smallest subarray containing all three is [B, A, C] (indices 1..3), length = 3.

Key Idea :
Think of this as a shopping cart window.
Target set = the full shopping list
First, figure out how many unique categories exist in the entire array. That’s required.
Expand Right = “put items in cart”
Move right forward, count categories in a map.
When cart is complete (have all categories) = “start shrinking”
If your window contains at least one of each category, try to shrink from the left to make it smaller.
Shrink Left = “remove extra items”
Move left forward while still keeping the cart complete.
The moment removing something makes it incomplete, stop shrinking and expand again.
This guarantees the minimum window because:
You only shrink when the window is valid (contains everything).
You shrink as much as possible each time.

*/
import java.util.*;

public class SmallestSubarrAllCategories {

    // Returns [startIndex, endIndex] of the smallest subarray
    // that contains at least one of every category.
    // If input is empty, returns [-1, -1].
    public static int[] smallestSubarrayAllCategories(String[] labels) {
        if (labels == null || labels.length == 0) {
            return new int[]{-1, -1};
        }

        // 1) Determine how many distinct categories exist in the entire array.
        //    This is the number of categories our window must cover.
        Set<String> allCategories = new HashSet<>();
        for (String x : labels) allCategories.add(x);
        int required = allCategories.size();

        // freq map for the current window [left..right]
        Map<String, Integer> freq = new HashMap<>();

        int formed = 0; // how many distinct categories currently have count >= 1 in the window
        int left = 0;

        // best answer tracking
        int bestLen = Integer.MAX_VALUE;
        int bestL = -1, bestR = -1;

        // 2) Expand with "right"
        for (int right = 0; right < labels.length; right++) {
            String cat = labels[right];

            // Add current category to the window frequency
            freq.put(cat, freq.getOrDefault(cat, 0) + 1);

            // If this category count became 1, we "formed" one required category
            if (freq.get(cat) == 1) {
                formed++;
            }

            // 3) If window is valid (contains all categories), shrink from the left
            while (formed == required) {
                // Update best window if current one is smaller
                int windowLen = right - left + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestL = left;
                    bestR = right;
                }

                // Try to remove labels[left] from the window (shrink)
                String leftCat = labels[left];
                freq.put(leftCat, freq.get(leftCat) - 1);

                // If a category count drops to 0, window is no longer complete
                if (freq.get(leftCat) == 0) {
                    formed--;
                }

                left++; // move left boundary forward
            }
        }

        return new int[]{bestL, bestR};
    }

    // Optional helper: returns the length only
    public static int smallestSubarrayAllCategoriesLength(String[] labels) {
        int[] ans = smallestSubarrayAllCategories(labels);
        if (ans[0] == -1) return 0;
        return ans[1] - ans[0] + 1;
    }

    // Quick manual test
    public static void main(String[] args) {
        String[] labels = {"A", "B", "A", "C", "B", "A"};
        int[] ans = smallestSubarrayAllCategories(labels);
        System.out.println(Arrays.toString(ans)); // [1, 3]
        System.out.println(smallestSubarrayAllCategoriesLength(labels)); // 3
    }
}

