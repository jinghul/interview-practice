class Solution {
    public int findKthLargest(int[] nums, int k) {
        // if (nums.length < 1 || k > nums.length) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++)
        {
            heap.add(nums[i]);
            if (heap.size() > k) heap.poll();
        }
        
        return heap.poll();
    }
}