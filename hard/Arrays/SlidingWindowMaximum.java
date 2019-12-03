class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 1) return nums;
        else if (k > nums.length) k = nums.length;
        
        LinkedList<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        
        // first window
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
            {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        result[0] = nums[deque.peekFirst()];
        
        // rest of array
        for (int i = k; i < nums.length; i++)
        {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.removeFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            deque.addLast(i);
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        
        return result;
    }
}