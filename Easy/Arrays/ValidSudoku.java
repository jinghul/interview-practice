/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++)
        {
            if (!validRow(board, i) || !validCol(board, i)) return false;
        }
        
        for (int i = 0; i < 9; i+=3)
        {
            for (int j = 0; j < 9; j += 3)
            {
                if (!validBox(board, i, j)) return false;
            }
        }
        
        return true;
    }
    
    public boolean validBox(char[][] board, int row, int col)
    {
        // if (row > 6 || col > 6) return false;
        boolean[] check = new boolean[9];
        for (int i = row; i < row + 3; i++)
        {
            for (int j = col; j < col + 3; j++)
            {
                int code = board[i][j] - '1';
                if (code < 0) continue;
                else if (check[code]) return false;
                else check[code] = true;
            }
        }
        return true;
    }
    
    public boolean validRow(char[][] board, int row)
    {
        boolean[] check = new boolean[9];
        for (int i = 0; i < 9; i++)
        {
            int code = board[row][i] - '1';
            if (code < 0) continue;
            else if (check[code]) return false;
            else check[code] = true;
        }
        return true;
    }
    
    public boolean validCol(char[][] board, int col)
    {
        boolean[] check = new boolean[9];
        for (int i = 0; i < 9; i++)
        {
            int code = board[i][col] - '1';
            if (code < 0) continue;
            else if (check[code]) return false;
            else check[code] = true;
        }
        return true;
    }
}