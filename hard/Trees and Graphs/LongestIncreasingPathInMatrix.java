// Solution 1: DFS with DP map for longest path of greater than numbers from this point.
// greater than condition ensures no overlap between current path and the call to this cell.

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[][] pathlen = new int[matrix.length][matrix[0].length];
        int maxlen = 0;
        for (int x = 0; x < matrix.length; x++)
        {
            for (int y = 0; y < matrix[x].length; y++)
            {
                maxlen = Math.max(maxlen, findPath(matrix, pathlen, x, y));
            }
        }
        return maxlen;
    }
    
    public int findPath(int[][] matrix, int[][] pathlen, int x, int y)
    {
        if (pathlen[x][y] > 0) return pathlen[x][y];
        
        int currlen = 0;
        for (int dx = -1; dx < 2; dx += 2)
        {
            if (x + dx > -1 && x + dx < matrix.length && matrix[x+dx][y] > matrix[x][y])
            {
                currlen = Math.max(currlen, findPath(matrix, pathlen, x + dx, y));
            }
        }
        
        for (int dy = -1; dy < 2; dy += 2)
        {
            if (y + dy > -1 && y + dy < matrix[x].length && matrix[x][y+dy] > matrix[x][y])
            {
                currlen = Math.max(currlen, findPath(matrix, pathlen, x, y + dy));
            }
        }
        
        pathlen[x][y] = ++currlen;
        return currlen;
    }
}