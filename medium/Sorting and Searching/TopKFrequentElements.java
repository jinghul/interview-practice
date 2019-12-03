class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            if (countMap.containsKey(nums[i]))
            {
                countMap.put(nums[i], countMap.get(nums[i])+1);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> countMap.get(n1) - countMap.get(n2));
        
        for (Integer key : countMap.keySet())
        {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }
        
        return new ArrayList<Integer>(heap);
    }
}