class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        Arrays.sort(intervals, (l1, l2) -> l1[0] - l2[0]);
        
        int last = 0;
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] > intervals[last][1])
            {
                intervals[++last] = intervals[i];
            } else if (intervals[i][1] > intervals[last][1])
            {
                intervals[last][1] = intervals[i][1];
            }
        }
        
        return Arrays.copyOf(intervals, last + 1);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        Arrays.sort(intervals, (l1, l2) -> l1[0] - l2[0]);
        
        int last = 0;
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] <= intervals[last][1])
            {
                if (intervals[i][1] <= intervals[last][1]) continue;
                else
                {
                    intervals[last][1] = intervals[i][1];
                }
            } else {
                last++;
                intervals[last][0] = intervals[i][0];
                intervals[last][1] = intervals[i][1];
            }
        }
        
        int[][] result = Arrays.copyOfRange(intervals, 0, last+1);
        return result;
    }
}