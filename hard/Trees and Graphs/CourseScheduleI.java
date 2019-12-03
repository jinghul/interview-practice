// Solution 1: DFS while finding subcycles
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 2) return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            if (!graph.containsKey(pair[0])) graph.put(pair[0], new ArrayList<Integer>());
            graph.get(pair[0]).add(pair[1]);
        }
        
        boolean[] discovered = new boolean[numCourses];
        boolean[] trace = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++)
        {
            if (!discovered[i])
            {   
                if (findCycle(graph, discovered, trace, i)) return false;
            }
        }
        
        return true;
    }
    
    public boolean findCycle(HashMap<Integer, List<Integer>> graph, boolean[] discovered, boolean[] trace, int course)
    {
        if (trace[course]) return true;
        else if (discovered[course]) return false;
        
        trace[course] = true;
        discovered[course] = true;
        
        if (graph.containsKey(course)) 
        {
            for (int edge : graph.get(course)) {
                if (findCycle(graph, discovered, trace, edge)) return true;
            }
        }
        
        trace[course] = false;
        return false;
    }
}

// Solution 2: BFS topological sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 2) return true;
        
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for (int[] edge : prerequisites)
        {
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList<Integer>();
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        
        int visited = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++)
        {
            if (indegree[course] == 0) queue.add(course);
        }
        
        while (!queue.isEmpty())
        {
            int course = queue.poll();
            visited++;
            
            if (graph[course] == null) continue;
            for (int edge : graph[course])
            {
                indegree[edge]--;
                if (indegree[edge] == 0) queue.add(edge);
            }
        }
        
        return visited == numCourses;
    }
}