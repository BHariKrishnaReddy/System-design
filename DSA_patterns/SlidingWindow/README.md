# Sliding Window

Problem type it solves :
* Sliding Window is used when you need to examine contiguous (continuous) parts of an array/string.

Examples:
1. Longest subarray with something
2. Smallest subarray that meets a condition
3. Count subarrays with specific properties
4. Maximum/minimum sum of any window of size K

### Why do we need Sliding Window?

* Without sliding window / Brute force approach:  `Check all possible subarrays → O(n²) time.`

* Sliding window approach:
    * Instead of recomputing the whole subarray every time, we "slide" from left to right and efficiently update the answer → O(n) time.

### Idea

We maintain a window defined by two pointers:
* **left** (start of window) and **right** (end of window)
* As right moves forward: we expand window
* if window becomes invalid, we shrink window by moving left
* You do **NOT recalculate from scratch**. You simply update the old sum.

### Two major types of sliding windows
* Type 1: **Fixed**-size window. Window size = constant (K).

* Type 2: **Variable**-size window. Window size changes based on condition.

`This is the pattern:  expand → break condition → shrink → restore validity → continue`

🔑 How to identify Sliding Window problems
* Look for these keywords in a problem statement:
* subarray / substring
* contiguous
* at most K
* longest / shortest
* sum / average
* "without repeating"
* "with K distinct"
* If it requires checking every possible continuous segment, sliding window is the right tool.

## Step-by-Step Logic Template

```
left = 0                                             // start of window
for right in range(len(arr)):                        //right end of window

    include arr[right] into window                   //Expand by moving right

    while window becomes invalid:
         remove arr[left]                            //Shrink by moving left
         left++

    update answer (if needed)
```

## Questions to Practice (No Duplicates, No Same-Pattern Variants)

Practice in [Leet-Code](https://leetcode.com/problem-list/sliding-window/) It can track your progress...

## 📅 7-Day Sliding Window Mastery Roadmap

### **Day 1 & 2  – Fundamentals (Easy Level)**

| Checkbox | Level | Question                                                                                  | Topics Covered                                 |
|----------|--------|--------------------------------------------------------------------------------------------|-------------------------------------------------|
| [x]      | Easy   | [Longest substring without repeating characters](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Easy/Longestsubstringwithoutrepeatingcharacters.java)                                            | Unique Window, HashSet, Expand–Shrink          |
| [x]      | Easy   | [Check if string B is a permutation of any substring of A](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Easy/CheckIfStringBisPermutationOfAnysubstringofA.java)                                  | Fixed Window, Frequency Count, Anagram Check   |
| [x]      | Easy   | [Count substrings with at most K distinct characters](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Easy/LongestSubstringWithAtMostKDistinctCharacters.java)                                       | Frequency Map, Variable Window                 |
| [x]      | Easy   | [Longest substring with at most K distinct characters](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/CompleteSlidingWindow/LongestSubstringWithAtMostKdistinctChanracters.java) and [ArrayBasedImplementaion](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Easy/LongestSubstringWithAtMostKDistinctCharactersArrayImplementaion.java)                                     | K-Distinct Constraint, Shrinking Window        |
| [x]      | Easy   | [Count subarrays where number of odd elements is ≤ K](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Easy/CountSubarraysWhereNumberofOddElementsisLessThanK.java)                                       | Conditional Window, Expand–Shrink              |
| [x]      | Easy   | [Longest subarray with at most K zeroes (flip zeroes to ones)](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Easy/LongestSubarrayWithatMostKZeroesflipZeroestoOnes.java)                              | Boolean Constraint, Binary Window Workflow     |

---

### **Day 3 & 4 – Core Interview Problems (Medium Level)**

| Checkbox | Level | Question                                                                                  | Topics Covered                                  |
|----------|--------|--------------------------------------------------------------------------------------------|--------------------------------------------------|
| [x]      | Medium | [Minimum window substring (smallest substring containing all pattern chars)](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Medimum/MinimumWindowSubstring.java)                | Covering Window, Sliding Frequency              |
| [x]      | Medium | [Longest substring where vowels appear in non-decreasing order](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Medimum/longestVowelNonDecreasingSubstring.java)                             | Order-Based Window, Validity Rules              |
| [x]      | Medium | [Smallest subarray containing at least one of each category label](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Medimum/SmallestSubarrAllCategories.java)                           | Category Coverage, Shrink for Minimal Window    |
| [x]      | Medium | [Check if any subarray of length ≥ 2 has duplicate elements](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Medimum/CheckDuplicateSubarray.java)                                | Window Validity, Duplicate Detection            |
| [x]      | Medium | [Count subarrays with sum < K (positive integers)](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Medimum/countSubarraysWithSumLessthanK.java)                                          | Sum-Constraint Window                           |
| [self]      | Medium | Longest subarray with sum ≤ K (positive integers)                                         | Expand–Shrink, Sum Inequality                   |
| [self]      | Medium | Longest subarray with product < K                                                         | Multiplicative Window, Expand–Shrink            |
| [x]      | Medium | [Count subarrays where no element appears more than twice](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Medimum/CountSubarraysNoElementMoreThanTwice.java)                                  | Frequency Constraints, Valid Window             |
| [x]      | Medium | [Longest substring where you can replace ≤ K characters to make all letters same](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Medimum/LongestRepeatingCharacterReplacement.java)           | Character Replacement, Frequency Max Window     |

---

### **Day 5 & 6 – Advanced Mastery (Hard Level)**

| Checkbox | Level | Question                                                                                  | Topics Covered                                   |
|----------|--------|--------------------------------------------------------------------------------------------|---------------------------------------------------|
| [x]      | Hard   | [Longest subarray where max(arr) – min(arr) ≤ X](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Hard/LongestSubarrayMaxMinDiff.java)                                            | Monotonic Queue, Range-Controlled Window         |
| [x]      | Hard   | [Count subarrays whose average ≥ threshold T](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Hard/CountSubarraysWithAverageAtLeastT.java)                                               | Sum Transformations, Dynamic Window Rules        |
| [x]      | Hard   | [Longest subarray that can be rearranged into a consecutive sequence](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Hard/LongestConsecutiveRearrangedSubarray.java)                       | Max-Min Window, Duplicate & Range Constraints    |
| [x]      | Hard   | [Sliding Window Maximum using deque (max of every window of size K)](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Hard/SlidingWindowMaximum.java)                        | Monotonic Deque, Fixed-Size Window               |
| [x]      | Hard   | [Compute sum(max − min) for every window of size K](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/SlidingWindow/Hard/SumOfMaxMinusMin.
java)                                         | Dual Deque (Max+Min), High-Level Window Pattern  |


### **Day 7 – Practice  the problems again. **

## 🧠 Sliding Window & Deque — Mental Strings and Pattern Recognition

| Problem / Pattern | Mental String (What to Recall Instantly) | Pattern Recognition Signal |
|-------------------|------------------------------------------|-----------------------------|
| **Count subarrays with sum < K (positive)** | “Valid window ⇒ count all suffixes.” | Contiguous + positive numbers + count |
| **Longest subarray with sum ≤ K (positive)** | “Expand, shrink if needed, track max length.” | Contiguous + positive numbers + longest |
| **Count subarrays with at most K odds / zeroes** | “Track bad elements; valid window ⇒ count suffixes.” | At most K constraint + counting |
| **Longest subarray with at most K zeroes** | “Keep window valid, update max length.” | Flip / tolerate K bad elements |
| **Count subarrays where no element appears more than twice** | “If frequency exceeds limit, shrink; valid ⇒ count suffixes.” | Frequency limit + counting |
| **Longest substring with at most K distinct characters** | “Too many distinct → shrink; valid ⇒ update max.” | Distinct count constraint |
| **Minimum window substring** | “Cover all required chars, then shrink to minimum.” | Need full coverage of pattern |
| **Longest substring with character replacement ≤ K** | “Keep most frequent, replace the rest.” | Replace characters + dominant frequency |
| **Sliding Window Maximum (size K)** | “Remove smaller from back, read max from front.” | Fixed window + max needed |
| **Sum of (max − min) for every window of size K** | “Two deques → range in O(1).” | Fixed window + both max and min |
| **Longest subarray where max − min ≤ X** | “Maintain max and min; shrink when diff breaks.” | Range constraint inside window |
| **Check duplicate in any subarray (≥ 2)** | “Duplicate inside window ⇒ answer found.” | Uniqueness violation |
| **Count subarrays with average ≥ T (fixed K)** | “Average ≥ T ⇒ sum ≥ K×T.” | Fixed window + average |
| **Longest subarray rearrangeable to consecutive** | “Distinct + (max − min + 1 = length).” | Rearrangement + consecutive check |

---

### 🧩 How to use this table
- **Read the problem**
- Match the **Pattern Recognition Signal**
- Recall the **Mental String**
- The technique chooses itself

> If you can recall the mental string, you already know the solution shape.
