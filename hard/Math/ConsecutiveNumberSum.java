class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 1;
        for (int i = 2; ; i++)
        {
            int diff = N - (i * (i - 1)) / 2;
            if (diff < i) break;
            else if (diff % i == 0) count++;
        }
        return count;
    }
}

class Solution {
    public int consecutiveNumbersSum(int N) {
        int max = (int)Math.sqrt(N);
        int count = 1;
        
        for (int i = 2; i <= max; i++)
        {
            double nseq = (i * (i - 1)) / 2;
            if ((N - nseq) % i == 0)
            {
                count += 1;
            }
        }
        
        return count;
    }
}

class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        double dN = N;
        for (int i = 1; i <= N; i++)
        {
            double avg = dN / i;
            double flr = Math.floor(avg);
            if (avg - (i / 2) <= 0) break;
            else if ((i % 2 == 1 && avg - flr == 0) || (i%2==0 && avg - flr == 0.5))
            {
                count++;
            }
        }
        return count;
    }
}