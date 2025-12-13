/*

Check if string B is a permutation of any substring of A.

Does A contain any substring that is a permutation (rearrangement) of B?
If yes, return true -     -If no, return false.

A “permutation” means:
    1.Same characters as B
    2.Same frequency
    3.Order does not matter
    
    Examples of permutations:
    "abc" → "cba", "bac", "cab", "bca" … all valid
    "aab" → "aba", "baa" are valid; "abb" is not

<-----Importnat Code explaintion--->

int[] freqB = new int[26];
        for (char c : B.toCharArray()) {
            freqB[c - 'a']++;
        }

    so int[] freqB = new int[26] is  [0,0,0,...25 zero's....0,0,0,0] represnting 26 alphabet postions
    so freqB[0] = count of a in B

    freqB[c-'a']++
    We take a character c from string B.
    We subtract 'a' from it: c - 'a'.
    This converts the character into an index from 0 to 25 based on ASCII values:
    'a' - 'a' = 0
    'b' - 'a' = 1
    'c' - 'a' = 2
    ...
    'z' - 'a' = 25
    Then we increment freqB[index], which increases the count of that character.
    So freqB[x] stores how many times that character appears in B, where x is its alphabetical index.
*/


package DSA_patterns.SlidingWindow.Easy;

public class CheckIfStringBisPermutationOfAnysubstringofA {

    public boolean permutationofB(String A,String B){

        if (A.length() < B.length()){
            return false;
        }
        
        // Sliding window frequency for A
        int[] freqA = new int[26];

        int lenB = B.length();

        // Frequency of B
        int[] freqB = new int[26];
        for (char c : B.toCharArray()) {
            freqB[c - 'a']++;
        }

        // First window of size lenB
        for (int i = 0; i < lenB; i++) {
            freqA[A.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(freqA, freqB)) return true;

        // Slide the window
        for (int r = lenB; r < A.length(); r++) {

            // Add new char
            freqA[A.charAt(r) - 'a']++;

            // Remove old char
            freqA[A.charAt(r - lenB) - 'a']--;

            // Check match
            if (matches(freqA, freqB)) {
                return true;
            }
        }

        return false;
    }
    
    // Helper: compare two frequency arrays
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // Quick testing
    public static void main(String[] args) {
        CheckIfStringBisPermutationOfAnysubstringofA sol = new CheckIfStringBisPermutationOfAnysubstringofA();

        System.out.println(sol.permutationofB("oidbcaf", "abc")); // true
        System.out.println(sol.permutationofB("hello", "oel"));   // false
        System.out.println(sol.permutationofB("abc", "cba"));     // true
    }
}
