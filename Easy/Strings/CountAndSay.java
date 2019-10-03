/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/886/
*/

class Solution {
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        if (n == 1) return str.toString();
        
        for (int i = 2; i <= n; i++)
        {
            String pattern = str.toString();
            str.setLength(0);

            int index = 0;
            for (int j = 0; j < pattern.length(); j++)
            {
                if (pattern.charAt(j) != pattern.charAt(index))
                {
                    str.append(j - index);
                    str.append(pattern.charAt(index));
                    index = j;
                }
            }
            str.append(pattern.length() - index);
            str.append(pattern.charAt(index));
        }
        
        return str.toString();
    }
}