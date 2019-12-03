class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        int max = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : nums)
        {
            if (num == Integer.MIN_VALUE || set.contains(num - 1)) continue;
            int count = 1;
            while (set.contains(++num)) count++;
            max = Math.max(count, max);
        }
        
        return max;
    }
}