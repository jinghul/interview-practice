class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {search(nums, target, true), search(nums, target, false)};
    }
    
    public int search(int[] nums, int target, boolean left)
    {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
            {
                if (left)
                {
                    if (mid - 1 < 0 || nums[mid-1] < target)
                    {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                }
                else
                {
                    if (mid + 1 > nums.length - 1 || nums[mid + 1] > target)
                    {
                        return mid;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        
        return -1;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] {-1, -1};
        if (nums.length < 1) return range;
        
        int start = 0, end = nums.length-1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target)
            {
                start = mid + 1;
            } else if (nums[mid] > target)
            {
                end = mid - 1;
            } else {
                range[0] = searchLeft(nums, start, mid, target);
                range[1]= searchRight(nums, end, mid, target);
                break;
            }
        }
        return range;
    }
    
    public int searchLeft(int[] nums, int start, int found, int target)
    {
        while (start <= found)
        {
            int mid = start + (found - start) / 2;
            if (nums[mid] == target)
            {
                if (mid == start || nums[mid-1] < target) return mid;
                else {
                    found = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return found;
    }
    
    public int searchRight(int[] nums, int end, int found, int target)
    {
        while (found <= end)
        {
            int mid = found + (end - found) / 2;
            if (nums[mid] == target)
            {
                if (mid == end || nums[mid+1] > target) return mid;
                else {
                    found = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        }
        return found;
    }
}