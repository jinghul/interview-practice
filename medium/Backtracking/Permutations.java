class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 1) return result;
        permute(result, nums, 0);
        return result;
    }
    
    public void permute(List<List<Integer>> result, int[] curr, int index)
    {
        if (index == curr.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int i = 0; i < curr.length; i++) {
                permutation.add(curr[i]);
            }
            result.add(permutation);
        } else {
            for (int i = index; i < curr.length; i++)
            {
                int temp = curr[i];
                curr[i] = curr[index];
                curr[index] = temp;
                permute(result, curr, index+1);
                curr[index] = curr[i];
                curr[i] = temp;
            }
        }
    }
}