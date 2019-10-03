/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getSubtree(nums, 0, nums.length-1);
    }
    
    public TreeNode getSubtree(int[] nums, int left, int right)
    {
        if (left > right) return null;
        else if (left == right) return new TreeNode(nums[left]);
        else {
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getSubtree(nums, left, mid-1);
            node.right = getSubtree(nums, mid+1, right);
            return node;
        }
    }
}