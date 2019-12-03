class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1) return result;
        
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++)
        {
            int size = result.size();
            for (int j = 0; j < size; j++)
            {
                List<Integer> sublist = new ArrayList<>(result.get(j));
                sublist.add(nums[i]);
                result.add(sublist);
            }
        }
        
        return result;
    }
}