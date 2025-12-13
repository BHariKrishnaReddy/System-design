/*

Longest substring without repeating characters

Given a string s, find the length of the longest substring that contains no repeated characters.
Example:
s = "abcabcbb" → output = 3 (substring "abc")
*/

package DSA_patterns.SlidingWindow.Easy;

import java.util.Set;
import java.util.HashSet;

public class Longestsubstringwithoutrepeatingcharacters {

    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int maxLen = 0;

        // Using a set to store unique characters in the window
        Set<Character> window = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character already in window, shrink from left
            while (window.contains(ch)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Add new character and update max length
            window.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
