class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int po5 = 5;
        int max = Integer.MAX_VALUE / 5;
        
        while (po5 <= n)
        {
            count += n / po5;
            if (po5 <= max) po5 *= 5;
            else break;
        }
        
        return count;
    }
}

class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int prev = 1;
        int pof = 5;
        while (pof <= n)
        {
            count += n / pof;
            pof *= 5;
            prev *= 5;
            
            if (pof / 5 != prev) break;
        }
        return count;
    }
}