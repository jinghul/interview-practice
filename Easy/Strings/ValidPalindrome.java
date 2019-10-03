/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/883/
 */

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r)
        {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if (!Character.isLetterOrDigit(left)) l++;
            else if (!Character.isLetterOrDigit(right)) r--;
            else if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        
        return true;
    }
}