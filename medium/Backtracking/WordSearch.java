class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length < 1) return false;
        
        boolean[][] discovered = new boolean[board.length][board[0].length];
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < board.length; x++)
        {
            for (int y = 0; y < board[x].length; y++)
            {
                if (search(board, discovered, word, builder, x, y)) return true;
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, boolean[][] discovered, String word, StringBuilder builder, int x, int y)
    {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || discovered[x][y] || board[x][y] != word.charAt(builder.length())) return false;
        
        builder.append(board[x][y]);
        discovered[x][y] = true;
        boolean result = false;
        
        if (builder.length() == word.length())
        {
            result = builder.toString().equals(word);
        } else if (search(board, discovered, word, builder, x-1, y) || search(board, discovered, word, builder, x+1, y) || search(board, discovered, word, builder, x, y-1) || search(board, discovered, word, builder, x, y + 1)) {
            result = true;
        }
        
        discovered[x][y] = false;
        builder.deleteCharAt(builder.length()-1);
        return result;
    }
}