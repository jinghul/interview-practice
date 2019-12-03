class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        // forwards
        int tracker = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            result[i] = tracker;
            tracker *= nums[i];
        }
        
        // backwards
        result[0] = 1;
        tracker = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--)
        {
            result[i] *= tracker;
            tracker *= nums[i];
        }
        return result;
    }
}