class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] ends = new int[nums.length];
        Arrays.fill(ends, Integer.MIN_VALUE);
        
        int maxIndex = -1;
        for (int num : nums)
        {
            int place = findPlace(nums, ends, num, maxIndex);
            maxIndex = Math.max(maxIndex, place);
            ends[place] = num;
        }
        
        return maxIndex + 1;
    }
    
    public int findPlace(int[] nums, int[] ends, int num, int maxIndex)
    {
        int start = 0;
        int end = maxIndex;
        
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (ends[mid] >= num)
            {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        int[] lens = new int[nums.length];
        int maxLength = 1;
        for (int i = 0; i < lens.length; i++)
        {
            maxLength = Math.max(maxLength, getSubsequenceLength(nums, lens, i));
        }
        return maxLength;
    }
    
    public int getSubsequenceLength(int[] nums, int[] lens, int index)
    {
        if (lens[index] != 0) return lens[index];
        
        int maxLength = 1;
        for (int i = index + 1; i < nums.length; i++)
        {
            if (nums[index] < nums[i])
            {
                maxLength = Math.max(maxLength, 1 + getSubsequenceLength(nums, lens, i));
            }
        }
        
        lens[index] = maxLength;
        return maxLength;
    }
}