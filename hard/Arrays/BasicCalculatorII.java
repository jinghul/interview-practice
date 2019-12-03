class Solution {
    public int calculate(String s) {
        if (s.length() == 0) return 0;
        
        int total = 0;
        int d1 = 0;
        int d2 = 0;
        char operation = '+';
        
        for (char c : s.toCharArray())
        {
            if (c > 47)
            {
                d2 = d2 * 10 + (c - '0');
            } else if (c == ' ') continue;
            else
            {
                if (operation == '+' || operation == '-') 
                {
                    total += d1;
                    d1 = operation == '-' ? -d2 : d2;
                } else if (operation == '*')
                {
                    d1 = d1 * d2;
                } else {
                    d1 = d1 / d2;
                }
                d2 = 0;
                operation = c;
            }
            
        }
        
        if (operation == '+') total += d1 + d2;
        else if (operation == '-') total += d1 - d2;
        else if (operation == '*') total += d1 * d2;
        else total += d1 / d2;
        
        return total;
    }
}