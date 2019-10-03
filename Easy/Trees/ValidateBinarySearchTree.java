/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

class Solution {

    public boolean isValidBST(TreeNode root) {
        return checkNode(root, (long)Integer.MAX_VALUE+1, (long)Integer.MIN_VALUE-1);
    }
    
    public boolean checkNode(TreeNode root, long max, long min)
    {
        if (root == null) return true;
        return root.val < max && root.val > min && checkNode(root.left, root.val, min) && checkNode(root.right, max, root.val);
    }
}