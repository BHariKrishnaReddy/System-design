package DSA_patterns.SlidingWindow.Easy;

public class LongestSubstringWithAtMostKDistinctCharactersArrayImplementaion {

    public int longestSubstring(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) {
            return 0;
        }

        int[] freq = new int[256]; // ASCII character frequency (Only lower case a-z then only 26)
        int left = 0;
        int distinctCount = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            if (freq[rightChar] == 0) {
                distinctCount++;
            }
            freq[rightChar]++;

            // shrink window if more than k distinct characters
            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;

                if (freq[leftChar] == 0) {
                    distinctCount--;
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
        LongestSubstringWithAtMostKDistinctCharactersArrayImplementaion sol =
                new LongestSubstringWithAtMostKDistinctCharactersArrayImplementaion();

        System.out.println(sol.longestSubstring("eceba", 2)); // 3
        System.out.println(sol.longestSubstring("aa", 1));    // 2
    }
}
