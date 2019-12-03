class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        else if (x <= 5) return x / 2;
        
        int start = 2;
        int end = x / 2;
        
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) return mid;
            else if (mid < x / mid) start = mid + 1;
            else end = mid - 1;
        }
        
        return end;
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int ans = 1;
        int start = 0, end = x;
        
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid)
            {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}