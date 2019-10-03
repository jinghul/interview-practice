/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/880/
*/

class Solution {
    public int reverse(int x) {
        int prev, curr = 0;

        while (x != 0)
        {
            int digit = x % 10;
            x /= 10;
            
            prev = curr;
            curr = curr * 10 + digit;
            
            if ((curr - digit) / 10 != prev) return 0;
        }
        
        return curr;
    }
}