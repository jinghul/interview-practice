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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        else if (p == q) return p;
        return find(root, p, q);
    }
    
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null) return null;
        else if (root == p || root == q) return root;
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left != null && right != null)
        {
            return root;
        } else if ( left == null && right == null) return null;
        else return left == null ? right : left;
    }
}