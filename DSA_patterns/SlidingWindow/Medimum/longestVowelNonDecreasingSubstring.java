package DSA_patterns.SlidingWindow.Medimum;

/*

Key idea : “Vowel Ladder: stay or climb, never fall”
Think of vowels in this fixed order:
a → e → i → o → u
While scanning the string left to right, you keep a current window length that represents the longest contiguous substring made only of vowels where each next vowel is same or higher on the ladder.

Rules:
Consonant = wall → break everything (cur = 0)
Vowel and it stays/climbs (rank ≥ previous rank) → extend (cur++)
Vowel but it falls (rank < previous rank) → restart at this vowel (cur = 1)
Track the maximum.
This is a single pass: O(n) time, O(1) space.
*/

class Solution {

    // Returns the "rank" on the vowel ladder:
    // a=0, e=1, i=2, o=3, u=4
    // If not a vowel, return -1.
    private int vowelRank(char c) {
        switch (c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default:  return -1; // non-vowel
        }
    }

    // Longest substring consisting only of vowels
    // such that vowels appear in non-decreasing order (a<=e<=i<=o<=u).
    public int longestVowelNonDecreasingSubstring(String s) {
        int maxLen = 0;

        int curLen = 0;        // length of current valid substring
        int prevRank = -1;     // vowel rank of previous character inside current substring

        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);
            int rank = vowelRank(ch);

            // 1) Consonant = wall => break the substring
            if (rank == -1) {
                curLen = 0;
                prevRank = -1;
                continue;
            }

            // Now we know ch is a vowel.

            // 2) If we're starting fresh (curLen == 0), begin a new substring
            if (curLen == 0) {
                curLen = 1;
                prevRank = rank;
            } else {
                // 3) We are continuing a vowel-only substring.
                //    Check if we "stay or climb" on the vowel ladder.
                if (rank >= prevRank) {
                    // Non-decreasing => extend
                    curLen++;
                    prevRank = rank;
                } else {
                    // Fell down the ladder => restart at this vowel
                    curLen = 1;
                    prevRank = rank;
                }
            }

            // 4) Update best answer
            if (curLen > maxLen) maxLen = curLen;
        }

        return maxLen;
    }
}

