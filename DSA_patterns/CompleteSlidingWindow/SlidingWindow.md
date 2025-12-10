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

## 📅 3-Day Sliding Window Mastery Roadmap

### **Day 1 – Fundamentals (Easy Level)**

| Checkbox | Level | Question                                                                                  | Topics Covered                                 |
|----------|--------|--------------------------------------------------------------------------------------------|-------------------------------------------------|
| [x]      | Easy   | [Longest substring without repeating characters](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/CompleteSlidingWindow/Longestsubstringwithoutrepeatingcharacters.java)                                            | Unique Window, HashSet, Expand–Shrink          |
| [x]      | Easy   | [Check if string B is a permutation of any substring of A](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/CompleteSlidingWindow/CheckIfStringBisPermutationOfAnysubstringofA.java)                                  | Fixed Window, Frequency Count, Anagram Check   |
| [ ]      | Easy   | [Count substrings with at most K distinct characters]()                                       | Frequency Map, Variable Window                 |
| [ ]      | Easy   | [Longest substring with at most K distinct characters]()                                      | K-Distinct Constraint, Shrinking Window        |
| [ ]      | Easy   | [Count subarrays where number of odd elements is ≤ K]()                                       | Conditional Window, Expand–Shrink              |
| [ ]      | Easy   | [Longest subarray with at most K zeroes (flip zeroes to ones)]()                              | Boolean Constraint, Binary Window Workflow     |

---

### **Day 2 – Core Interview Problems (Medium Level)**

| Checkbox | Level | Question                                                                                  | Topics Covered                                  |
|----------|--------|--------------------------------------------------------------------------------------------|--------------------------------------------------|
| [ ]      | Medium | Minimum window substring (smallest substring containing all pattern chars)                | Covering Window, Sliding Frequency              |
| [ ]      | Medium | Longest substring where vowels appear in non-decreasing order                             | Order-Based Window, Validity Rules              |
| [ ]      | Medium | Smallest subarray containing at least one of each category label                           | Category Coverage, Shrink for Minimal Window    |
| [ ]      | Medium | Check if any subarray of length ≥ 2 has duplicate elements                                | Window Validity, Duplicate Detection            |
| [ ]      | Medium | Count subarrays with sum < K (positive integers)                                          | Sum-Constraint Window                           |
| [ ]      | Medium | Longest subarray with sum ≤ K (positive integers)                                         | Expand–Shrink, Sum Inequality                   |
| [ ]      | Medium | Longest subarray with product < K                                                         | Multiplicative Window, Expand–Shrink            |
| [ ]      | Medium | Count subarrays where no element appears more than twice                                  | Frequency Constraints, Valid Window             |
| [ ]      | Medium | Longest substring where you can replace ≤ K characters to make all letters same           | Character Replacement, Frequency Max Window     |

---

### **Day 3 – Advanced Mastery (Hard Level)**

| Checkbox | Level | Question                                                                                  | Topics Covered                                   |
|----------|--------|--------------------------------------------------------------------------------------------|---------------------------------------------------|
| [ ]      | Hard   | Longest subarray where max(arr) – min(arr) ≤ X                                            | Monotonic Queue, Range-Controlled Window         |
| [ ]      | Hard   | Count subarrays whose average ≥ threshold T                                               | Sum Transformations, Dynamic Window Rules        |
| [ ]      | Hard   | Longest subarray that can be rearranged into a consecutive sequence                       | Max-Min Window, Duplicate & Range Constraints    |
| [ ]      | Hard   | Sliding Window Maximum using deque (max of every window of size K)                        | Monotonic Deque, Fixed-Size Window               |
| [ ]      | Hard   | Compute sum(max − min) for every window of size K                                         | Dual Deque (Max+Min), High-Level Window Pattern  |
