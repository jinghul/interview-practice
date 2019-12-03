class Solution {
    public void sortColors(int[] nums) {
        int placeRed = 0;
        int placeBlue = nums.length-1;
        
        for (int i = 0; i <= placeBlue; i++)
        {
            if (nums[i] == 0)
            {
                nums[i] = nums[placeRed];
                nums[placeRed++] = 0;
            } else if (nums[i]==2)
            {
                nums[i--] = nums[placeBlue];
                nums[placeBlue--] = 2;
            }
        }
    }
}