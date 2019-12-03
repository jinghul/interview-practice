/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        
        int start = 0;
        int maxLength = 0;
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (lastSeen.containsKey(c)) start = Math.max(lastSeen.get(c) + 1, start);
            lastSeen.put(c, i);
            maxLength = Math.max(i - start + 1, maxLength);
        }
        return maxLength;
    }
}