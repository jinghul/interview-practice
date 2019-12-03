class Solution {
    public void gameOfLife(int[][] board) {
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                int neighbors = getSum(board, row, col);
                if (board[row][col] == 1)
                {
                    if (neighbors < 2 || neighbors > 3){
                        board[row][col] = 2;
                    }
                } else if (neighbors == 3) {
                    board[row][col] = -1;
                }
            }
        }
        
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                if (board[row][col] == -1) board[row][col] = 1;
                else if (board[row][col] == 2) board[row][col] = 0;
            }
        }
    }
    
    public int getSum(int[][] board, int x, int y)
    {
        int sum = 0;
        for (int row = x - 1; row <= x + 1; row++)
        {
            if (row < 0 || row == board.length) continue;
            for (int col = y - 1; col <= y + 1; col++)
            {
                if (col < 0 || col == board[row].length) continue;
                if (board[row][col] > 0) sum++;
            }
        }
        return sum - board[x][y];
    }
}