package DSA_patterns.SlidingWindow.Medimum;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // assuming uppercase A-Z
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);

            // shrink window if replacements exceed k
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update longest valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol =
                new LongestRepeatingCharacterReplacement();

        System.out.println(sol.characterReplacement("AABABBA", 1)); // 4
    }
}
