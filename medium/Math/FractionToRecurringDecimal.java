class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) sb.append("-");
        
        long lnum = Math.abs((long) numerator);
        long ldenom = Math.abs((long) denominator);
        
        sb.append(lnum / ldenom);
        lnum = lnum % ldenom;
        if (lnum == 0) return sb.toString();
        
        sb.append(".");
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        while (lnum != 0)
        {
            if (remainderMap.containsKey(lnum))
            {
                sb.insert(remainderMap.get(lnum), "(");
                sb.append(")");
                return sb.toString();
            }
            
            remainderMap.put(lnum, sb.length());
            lnum *= 10;
            sb.append(lnum / ldenom);
            lnum = lnum % ldenom;
        }
        
        return sb.toString();
    }
}

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder num = new StringBuilder();
        
        if (numerator == 0)
        {
            return "0";
        }
        
        long lnum = numerator;
        long lden = denominator;
        
        // signs
        if ((lnum < 0 && lden > 0) || (lnum > 0 && lden < 0)) num.append("-");
        lnum = Math.abs(lnum);
        lden = Math.abs(lden);
        
        // whole integer
        long res = lnum / lden;
        lnum -= res * lden;
        num.append(res);

        
        if (lnum != 0)
        {
            num.append(".");
            HashMap<Long, Integer> nums = new HashMap<>();
            
            while (lnum != 0)
            {
                lnum *= 10;   
                if (nums.containsKey(lnum))
                {
                    num.insert(nums.get(lnum), "(");
                    num.append(")");
                    break;
                } else {
                    nums.put(lnum, num.length());
                }
                
                res = lnum / lden;
                lnum -= lden * res;
                num.append(res);
            }
        }
        
        return num.toString();
    }
}