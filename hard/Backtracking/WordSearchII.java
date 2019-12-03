class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (words.length == 0) return new ArrayList<>();
        
        // build trie
        Map<Character, Map> trie = new HashMap<>();
        for (String word : words)
        {
            Map<Character, Map> currMap = trie;
            for (char c : word.toCharArray())
            {
                if (!currMap.containsKey(c))
                {
                    currMap.put(c, new HashMap<Character, Map>());
                }
                currMap = currMap.get(c);
            }
            
            // end character
            currMap.put('$', null);
        }
        
        HashSet<String> set = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuilder sb = new StringBuilder();
        
        for (int x = 0; x < board.length; x++)
        {
            for (int y = 0; y < board[x].length; y++)
            {
                findWords(board, trie, visited, set, sb, x, y);
            }
        }
        
        List<String> result = new ArrayList<>(set.size());
        for (String s : set) result.add(s);
        return result;
    }
    
    public void findWords(char[][] board, Map<Character, Map> trie, boolean[][] visited, HashSet<String> results, StringBuilder sb, int x, int y)
    {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || visited[x][y] || !trie.containsKey(board[x][y])) return;
        
        visited[x][y] = true;
        
        sb.append(board[x][y]);
        trie = trie.get(board[x][y]);
        
        // add string if it is a word in the list
        if (trie.containsKey('$')) results.add(sb.toString());
        
        findWords(board, trie, visited, results, sb, x+1, y);
        findWords(board, trie, visited, results, sb, x-1, y);
        findWords(board, trie, visited, results, sb, x, y+1);
        findWords(board, trie, visited, results, sb, x, y-1);
        
        sb.deleteCharAt(sb.length() - 1);
        visited[x][y] = false;
    }
}