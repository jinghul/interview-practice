class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] <= 0) nums[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if (index < nums.length) {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
}