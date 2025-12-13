/*
Count Substrings With At Most K Distinct Characters” means:
Find how many continuous parts of the string contain no more than K different characters.

What does “at most K distinct characters” mean?
    It means:
        The substring can have K different characters or fewer.
    It can have:
        1 distinct character 
        K distinct characters 
        More than K  (not allowed)


*/


package DSA_patterns.SlidingWindow.Easy;

public class CountSubstringsWithAtMostKdistinctCharacters {

    public int countSubstrings(String s, int k) {
        int left = 0;
        int result = 0;
        int[] freq = new int[256];
        int distinct = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            if (freq[ch] == 0) {
                distinct++;
            }
            freq[ch]++;

            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                if (freq[leftChar] == 0) {
                    distinct--;
                }
                left++;
            }

            result += (right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        CountSubstringsWithAtMostKdistinctCharacters sol = new CountSubstringsWithAtMostKdistinctCharacters();
        System.out.println(sol.countSubstrings("abcba", 2)); // Expected: 10
    }
}

