/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int LEFT_TO_RIGHT = 1;
        int RIGHT_TO_LEFT = 0;
        
        int direction = LEFT_TO_RIGHT;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            LinkedList<Integer> row = new LinkedList<>();
            
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (direction == LEFT_TO_RIGHT)
                {
                    row.add(node.val);
                } else {
                    row.offerFirst(node.val);
                }
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            direction = direction == LEFT_TO_RIGHT ? RIGHT_TO_LEFT : LEFT_TO_RIGHT;
            result.add(row);
        }
        
        return result;
    }
}