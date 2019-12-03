class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        int n = A.length;
        if (n == 0) return count;
        HashMap<Integer, Integer> sums = new HashMap<>();
        
        for (int a = 0; a < n; a++)
        {
            for (int b = 0; b < n; b++)
            {
                int sum = A[a] + B[b];
                if (!sums.containsKey(sum)) sums.put(sum, 0);
                sums.put(sum, sums.get(sum) + 1);
            }
        }
        
        for (int c = 0; c < n; c++)
        {
            for (int d = 0; d < n; d++)
            {
                int sum = C[c] + D[d];
                if (sums.containsKey(-sum))
                {
                    count += sums.get(-sum);
                }
            }
        }
        
        return count;
    }
}