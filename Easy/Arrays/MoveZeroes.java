/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/567/
*/

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        
        int place = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
            {
                if (place != i)
                {
                    nums[place] = nums[i];
                    nums[i] = 0;
                }
                place++;
            }
        }
    }
}