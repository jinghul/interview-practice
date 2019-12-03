// Solution:
// Get recursive path sums of children and return the maximum of 4 cases, one of which
// has to be maintained in an array as the path can start anywhere.
// 1. Node only
// 2. Node + right
// 3. Node + left
// 4. Node + left + right (only if starting node)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        getMaxSum(root, max);
        return max[0];
    }
    
    public int getMaxSum(TreeNode root, int[] max)
    {
        if (root == null) return 0;
        int left = getMaxSum(root.left, max);
        int right = getMaxSum(root.right, max);
        int current = Math.max(root.val, root.val + Math.max(left, right));
        max[0] = Math.max(max[0], Math.max(current, root.val + left + right));
        return current;
    }
}