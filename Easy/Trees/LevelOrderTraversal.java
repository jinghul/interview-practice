/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        
        while (!level.isEmpty())
        {
            List<Integer> levelInts = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for (int i = 0; i < level.size(); i++)
            {
                TreeNode node = level.get(i);
                levelInts.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            result.add(levelInts);
            level = nextLevel;
        }
        return result;
    }
}