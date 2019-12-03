// Solution 1: Same as Course Schedule I - requirements as indegrees
// topological sort on indegrees and return empty list if cycle
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] indegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for (int[] edge : prerequisites)
        {
            if (graph[edge[1]] == null) graph[edge[1]] = new ArrayList<Integer>();
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int course = 0; course < numCourses; course++)
        {
            if (indegree[course] == 0) queue.add(course);
        }
        
        int visited = 0;
        while (!queue.isEmpty())
        {
            int course = queue.poll();
            order[visited++] = course;
            
            if (graph[course] == null) continue;
            
            for (int edge : graph[course])
            {
                if (--indegree[edge] == 0) queue.add(edge);
            }
        }
        
        return visited == numCourses ? order : new int[0];
        
    }
}