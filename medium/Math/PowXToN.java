class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        else if (n == 1) return x;
        else if (n == -1) return 1 / x;
        
        double half = myPow(x, n / 2);
        if (n < 0) x = 1 / x;
        return n % 2 == 0 ? half * half : half * half * x;
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double temp = myPow(x, n / 2);
        double ret = temp * temp;
        if (n % 2 != 0)
        {
            if (n > 0) ret *= x;
            else ret /= x;
        }
        return ret;
    }
}