/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        int[] result = carry == 1 ? new int[digits.length+1] : digits;
        if (carry == 1)
        {
            result[0] = 1;
            for (int i = 1; i < result.length; i++)
            {
                result[i] = digits[i-1];
            }
        }
        return result;
    }
}