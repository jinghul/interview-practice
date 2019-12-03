class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        else if (divisor == 1) return dividend;
        else if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        long ldividend =  Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        int quotient = 0;
        int multiplier = 1;
        while (ldividend >= ldivisor << 1) 
        {
            multiplier <<= 1;
            ldivisor <<= 1;
        }
        
        while (multiplier != 0)
        {
            if (ldividend >= ldivisor)
            {
                ldividend -= ldivisor;
                quotient += multiplier;
            }
            ldivisor >>= 1;
            multiplier >>= 1;
        }
        
        return sign == -1 ? 0-quotient : quotient;
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        else if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        int sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;
        dividend = negate(dividend);
        divisor = negate(divisor);
        
        int sigbit = 0;
        for (int i = 1; i < 32; i++)
        {
            if ((divisor >> i & 1) == 0) sigbit = i;
        }
        
        System.out.println(sigbit);
        
        int total = 0;
        for (int i = 31 - sigbit - 1; i >= 0; i--)
        {
            int multiple = divisor << i;
            if (multiple >= dividend) 
            {
                dividend -= multiple;
                total += 1 << i;
            }
        }
        
        return sign > 0 ? total : negate(total);
    }
    
    public int negate(int num)
    {
        if (num < 0) return num;
        int ret = -1;
        for (int i = 0; i < 32; i++)
        {
            ret ^= (num >> i & 1) << i;       
        }
        return ret + 1;
    }
}