// Solution 1: Basic graph search and marking down connected circles
class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) return 0;
        int count = 0;
        
        boolean[] discovered = new boolean[M.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < M.length; i++)
        {
            if (discovered[i]) continue;
            count++;
            queue.add(i);
            while (!queue.isEmpty())
            {
                int student = queue.poll();
                discovered[student] = true;
                for (int friend = 0; friend < M.length; friend++)
                {
                    if (M[student][friend] == 1 && !discovered[friend])
                    {
                        queue.add(friend);
                    }
                }
            }
        }
        
        return count;
    }
}

// Solution 2: Recursion
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int count = 0;
        
        boolean[] discovered = new boolean[M.length];
        for (int i = 0; i < M.length; i++)
        {
            if (discovered[i]) continue;
            count++;
            mark(M, discovered, i);
        }
        
        return count;
    }
    
    public void mark(int[][] M, boolean[] discovered, int i)
    {
        discovered[i] = true;
        for (int j = 0; j < M.length; j++)
        {
            if (M[i][j] == 1 && !discovered[j])
            {
                mark(M, discovered, j);
            }
        }
    }
}