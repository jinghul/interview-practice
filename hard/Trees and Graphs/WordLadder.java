// Solution 1: Bi-Directional BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String, List<String>> patternMap = new HashMap<>();
        boolean found = false;
        for (String word : wordList)
        {
            if (word.equals(endWord)) found = true;
            for (int i = 0; i < L; i++)
            {
                String pattern = word.substring(0, i) + "-" + word.substring(i+1, L);
                List<String> matchs = patternMap.getOrDefault(pattern, new ArrayList<String>());
                matchs.add(word);
                
                if (!patternMap.containsKey(pattern)) patternMap.put(pattern, matchs);
            }
        }
        if (!found) return 0;
        
        HashMap<String, Integer> fvisited = new HashMap<>();
        HashMap<String, Integer> bvisited = new HashMap<>();
        Queue<String> fqueue = new LinkedList<>();
        Queue<String> bqueue = new LinkedList<>();
        fvisited.put(beginWord, 1);
        fqueue.add(beginWord);
        bvisited.put(endWord, 1);
        bqueue.add(endWord);
        
        while (!bqueue.isEmpty())
        {
            String fword = fqueue.poll();
            int flen = fvisited.get(fword);
            
            for (int i = 0; i < L; i++)
            {
                String fpattern = fword.substring(0, i) + "-" + fword.substring(i+1, L);
                for (String match : patternMap.getOrDefault(fpattern, new ArrayList<String>()))
                {
                    if (bvisited.containsKey(match)) {
                        return flen + bvisited.get(match);
                    }
                    
                    if (!fvisited.containsKey(match))
                    {
                        fvisited.put(match, flen + 1);
                        fqueue.add(match);
                    }
                }
            }
            
            String bword = bqueue.poll();
            int blen = bvisited.get(bword);
            
            for (int i = 0; i < L; i++)
            {
                String bpattern = bword.substring(0, i) + "-" + bword.substring(i+1, L);
                for (String match : patternMap.getOrDefault(bpattern, new ArrayList<String>()))
                {
                    if (fvisited.containsKey(match)) {
                        return blen + fvisited.get(match);
                    }
                    
                    if (!bvisited.containsKey(match))
                    {
                        bvisited.put(match, blen + 1);
                        bqueue.add(match);
                    }
                }
            }
        }
        
        return 0;
    }
}


// Solution 2: Standard BFS
import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String, List<String>> patternMap = new HashMap<>();
        for (String word : wordList)
        {
            for (int i = 0; i < L; i++)
            {
                String pattern = word.substring(0, i) + "-" + word.substring(i+1, L);
                List<String> matchs = patternMap.getOrDefault(pattern, new ArrayList<String>());
                matchs.add(word);
                
                if (!patternMap.containsKey(pattern)) patternMap.put(pattern, matchs);
            }
        }
        
        HashSet<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        while (!queue.isEmpty())
        {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int len = pair.getValue();
            for (int i = 0; i < L; i++)
            {
                String pattern = word.substring(0, i) + "-" + word.substring(i+1, L);
                for (String match : patternMap.getOrDefault(pattern, new ArrayList<String>()))
                {
                    if (match.equals(endWord)) return len + 1;
                    if (!visited.contains(match))
                    {
                        visited.add(match);
                        queue.add(new Pair(match, len + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}