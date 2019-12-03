class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[start] <= nums[mid])
            {
                // if left half is sorted e.g. does not contain pivot
                if (nums[start] <= target && nums[mid] > target)
                {
                    end = mid - 1;
                } else {
                    start = mid + 1;   
                }
            } else {
                if (target <= nums[end] && nums[mid] < target)
                {
                   start = mid + 1; 
                } else {
                    end = mid - 1;   
                }
            }
        }
        
        return -1;
    }
}

// find pivot first then search still log n..
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        
        int pivot = 0;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (mid > 0 && nums[mid-1] > nums[mid])
            {
                pivot = mid;
                break;
            } else if (mid < nums.length - 1 && nums[mid + 1] < nums[mid]) {
                pivot = mid + 1;
                break;
            } else if (nums[start] > nums[mid])
            {
                end = mid - 1;
            } else if (nums[end] < nums[mid])
            {
                start = mid + 1;
            } else {
                break;
            }
        }
        
        
        start = 0;
        end = nums.length - 1;
        // System.out.println(pivot);
        
        if (target < nums[pivot])
        {
            return -1;
        } else if (pivot > 0 && target >= nums[start]) {
            end = pivot - 1;
        } else if (target >= nums[pivot])
        {
            start = pivot;
        }
        
        // System.out.println(start + " " + end);
        
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target)
            {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}