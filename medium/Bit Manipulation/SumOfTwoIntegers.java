class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++)
        {
            int abit = a & 1;
            int bbit = b & 1;
            sum |= (abit ^ bbit ^ carry) << i;
            carry = (abit & bbit) | (abit & carry) | (bbit & carry);
            
            a >>>= 1;
            b >>>= 1;
        }
        return sum;
    }
}

class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++)
        {
            int abit = a >> i & 1;
            int bbit = b >> i & 1;
            
            result |= (abit ^ bbit ^ carry) << i;
            
            if ((abit == 1 && bbit == 1) || (abit == 1 && carry == 1) || (bbit == 1 && carry == 1))
            {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        
        return result;
    }
}