package DSA_patterns.SlidingWindow.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int longestSubstring(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int maxLen = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // shrink window if more than k distinct characters
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            // update longest valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // quick test
    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters sol =
                new LongestSubstringWithAtMostKDistinctCharacters();

        System.out.println(sol.longestSubstring("eceba", 2)); // 3
        System.out.println(sol.longestSubstring("aa", 1));    // 2
    }
}

    

