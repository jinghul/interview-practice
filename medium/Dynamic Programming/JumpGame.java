class Solution {
    public boolean canJump(int[] nums) {
        int canReach = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (canReach < i) return false;
            canReach = Math.max(i + nums[i], canReach);
            if (canReach >= nums.length - 1) return true;
        }
        return false;
    }
}