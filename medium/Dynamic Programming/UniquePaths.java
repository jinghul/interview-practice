class Solution {
    public int uniquePaths(int m, int n) {
        double total = 1;
        m--; n--;
        int num = m+n;
        int r = m < n ? m : n;
        if (m == 0 || n == 0) r = num;
        
        while (num > r && r > 0)
        {
            total *= num--;
            total /= r--;
        }
        
        int base = (int)total;
        return total > base + 0.5 ? base + 1 : base;
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        
        int[][] paths = new int[n][m];
        for (int x = 0; x < n; x++)
        {
            for (int y = 0; y < m; y++)
            {
                if (x == 0 || y == 0) paths[x][y] = 1;
                else {
                    paths[x][y] = paths[x-1][y] + paths[x][y-1];
                }
            }
        }
        
        return paths[n-1][m-1];
    }
}