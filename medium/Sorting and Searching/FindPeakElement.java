class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length - 1 || nums[mid+1] < nums[mid]))
            {
                return mid;
            } else if (mid != 0 && nums[mid-1] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        
        while (s <= e)
        {
            int mid = s + (e - s) / 2;
            boolean gtl = mid - 1 < 0 || nums[mid - 1] < nums[mid];
            boolean gtr = mid + 1 > nums.length - 1 || nums[mid+1] < nums[mid];
            if (gtl && gtr) return mid;
            else if (gtl) s = mid + 1;
            else e = mid - 1;
        }
        
        return -1;
    }
}