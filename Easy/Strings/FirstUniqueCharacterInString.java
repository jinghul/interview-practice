/**
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/881/
 */

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars)
        {
            if (!count.containsKey(c)) count.put(c, 0);
            count.put(c, count.get(c)+1);
        }
        
        for (int i = 0; i < chars.length; i++)
        {
            if (count.get(chars[i]) == 1) return i;
        }
        
        return -1;
    }
}