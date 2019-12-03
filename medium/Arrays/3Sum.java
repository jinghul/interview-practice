/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int x = i + 1;
            int y = nums.length-1;
            
            while (x < y)
            {
                int sum = nums[i] + nums[x] + nums[y];
                if (sum == 0)
                {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[x++]);
                    triplet.add(nums[y--]);
                    result.add(triplet);
                    
                    while (x < y && nums[x] == nums[x-1]) x++;
                    while (x < y && nums[y] == nums[y+1]) y--;
                } else if (sum < 0)
                {
                    x++;
                } else {
                    y--;
                }
            }
        }
        
        return result;
    }
}