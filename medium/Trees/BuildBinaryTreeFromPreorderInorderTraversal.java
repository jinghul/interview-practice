/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) // or preorder.length != inorder.length...
        {
            return null;
        }
        
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
        {
            indexMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, indexMap, 0, inorder.length-1, 0);
    }
    
    public TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> indexMap, int start, int end, int preIndex)
    {
        if (start > end) return null;
        int inIndex = indexMap.get(preorder[preIndex]);
        
        TreeNode node = new TreeNode(preorder[preIndex]);
        node.left = buildTree(preorder, inorder, indexMap, start, inIndex-1, preIndex+1);
        node.right = buildTree(preorder, inorder, indexMap, inIndex+1, end, preIndex + (inIndex-start) + 1);
        return node;
    }
}