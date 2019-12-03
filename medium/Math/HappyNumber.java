class Solution {
    public boolean isHappy(int n) {
        int fast = squareSumDigits(squareSumDigits(n));
        int slow = squareSumDigits(n);
        
        while (fast != slow)
        {
            slow = squareSumDigits(slow);
            fast = squareSumDigits(squareSumDigits(fast));
        }
        
        return fast == 1;
        
    }
    
    public int squareSumDigits(int n)
    {
        int sum = 0;
        while (n != 0)
        {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n))
        {
            set.add(n);
            
            int sum = 0;
            while (n != 0)
            {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        
        return n == 1;
    }
}