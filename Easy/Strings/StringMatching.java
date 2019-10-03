/**
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */


class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        else if (needle.length() > haystack.length()) return -1;
        
        int target = 0, hash = 0, m = 1, d = 26, prime = 1137, len = needle.length();
        for (int i = 0; i < len; i++)
        {
            if (i != needle.length() - 1) m = (m * d) % prime;
            target = (target * d + needle.charAt(i)) % prime;
            hash = (hash * d + haystack.charAt(i)) % prime;
        }
        
        if (target == hash && haystack.substring(0, len).equals(needle)) return 0;
        
        for (int i = 0; i < haystack.length() - len; i++)
        {
            int c = haystack.charAt(i + len);
            hash = (d * (hash + prime - (haystack.charAt(i) * m) % prime) + c) % prime;
            if (hash == target && haystack.substring(i + 1, i + len + 1).equals(needle)) return i + 1;
        }
        
        return -1;
    }
}