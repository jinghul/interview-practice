class Solution {
    boolean[][] bGrid;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        if (grid.length < 1) return 0;
        this.grid = grid;
        this.bGrid = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (bGrid[i][j] || grid[i][j] == '0') continue;
                else {
                    count++;
                    checkNeighbors(i, j);
                }
            }
        }
        return count;
    }
    
    public void checkNeighbors(int i, int j)
    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || bGrid[i][j]) return;
        bGrid[i][j] = true;
        if (grid[i][j] == '1')
        {
            checkNeighbors(i-1, j);
            checkNeighbors(i+1, j);
            checkNeighbors(i, j-1);
            checkNeighbors(i, j+1);
        }
    }
}