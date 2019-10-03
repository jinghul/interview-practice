/**
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        else if (strs.length == 1) return strs[0];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++)
        {
            for (int j = 1; j < strs.length; j++)
            {
                if (strs[j].length() <= i) return sb.toString();
                else if (strs[j].charAt(i) != strs[0].charAt(i)) return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}