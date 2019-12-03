// Solution 1: start from edges and mark Os using DFS from there as those
// will stay O. Not marked Os will be converted to Xs as they are surrounded.

class Solution {
    public void solve(char[][] board) {
        if (board.length < 2) return;
        
        for (int row = 0; row < board.length; row++)
        {
            mark(board, row, 0);
            mark(board, row, board[row].length - 1);
        }
        
        for (int col = 1; col < board[0].length - 1; col++)
        {
            mark(board, 0, col);
            mark(board, board.length - 1, col);
        }
        
        for (int x = 0; x < board.length; x++)
        {
            for (int y = 0; y < board[x].length; y++)
            {
                if (board[x][y] == 'K') board[x][y] = 'O';
                else if (board[x][y] == 'O') board[x][y] = 'X';
            }
        }
    }
    
    public void mark(char[][] board, int x, int y)
    {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] == 'X' || board[x][y] == 'K') return;
        board[x][y] = 'K';
        mark(board, x+1, y);
        mark(board, x-1,y);
        mark(board, x, y+1);
        mark(board, x, y-1);
    }
}

// Solution 2: brute force DFS
import javafx.util.Pair;

class Solution {
    public List<Pair<Integer, Integer>> stack;
    public char[][] board;
    public boolean[][] discovered;
    public void solve(char[][] board) {
        if (board.length < 2) return;
        this.board = board;
        this.discovered = new boolean[board.length][board[0].length];
        this.stack = new ArrayList<>();
        
        for (int x = 0; x < board.length; x++)
        {
            for (int y = 0; y < board[x].length; y++)
            {
                if (!discovered[x][y] && board[x][y] == 'O')
                {
                    boolean surrounded = check(x, y);
                    if (surrounded)
                    {
                        for (Pair<Integer, Integer> pair : stack)
                        {
                            board[pair.getKey()][pair.getValue()] = 'X';
                        }
                    }
                    stack.clear();
                }
            }
        }
    }
    
    public boolean check(int x, int y)
    {
        if (x < 0 || x >= this.board.length || y < 0 || y >= this.board[x].length) return false;
        else if (this.discovered[x][y] || this.board[x][y] == 'X') return true;
        this.discovered[x][y] = true;
        this.stack.add(new Pair(x, y));
        
        boolean down = check(x+1, y);
        boolean up = check(x-1,y);
        boolean right = check(x, y+1);
        boolean left = check(x, y-1);
        return down && up && right && left;
    }
}