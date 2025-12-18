/*
Q. 
You are given:
A string S (the main string)
A string T (the pattern string)
The question asks:
What is the smallest contiguous substring of S that contains all the characters of T (including their required counts)?
If no such substring exists, return an empty result.

Key : Expand until you cover all required characters, then shrink as much as possible while staying valid.
*/


package DSA_patterns.SlidingWindow.Medimum;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> need = new HashMap<>();   // This map stores how many times each character is still needed.
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int matched = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // Sliding window
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (need.containsKey(rightChar)) {
                need.put(rightChar, need.get(rightChar) - 1);
                if (need.get(rightChar) >= 0) {
                    matched++;
                }
            }

            // Try to shrink the window when all chars are matched
            while (matched == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                left++;

                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar) == 0) {
                        matched--;
                    }
                    need.put(leftChar, need.get(leftChar) + 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }

    // quick test
    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(sol.minWindow("a", "aa"));             // ""
    }
}

    

