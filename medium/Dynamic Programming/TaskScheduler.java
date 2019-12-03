class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        int[] map = new int[26];
        for (char c : tasks) map[c-'A']++;
        Arrays.sort(map);
        
        int bound = map[map.length - 1] - 1;
        int idle = n * bound;
        
        for (int i = map.length - 2; i >= 0; i--)
        {
            if (map[i] == 0) break;
            idle -= Math.min(bound, map[i]);
        }
        
        return Math.max(tasks.length, idle + tasks.length);
    }
}