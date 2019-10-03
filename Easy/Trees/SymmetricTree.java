/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Note:
Bonus points if you could solve it both recursively and iteratively.
*/

// Recursive:
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right)
    {
        if (left == null && right == null) return true;
        else if ((left == null && right != null) || (left != null && right == null)) return false;
        else if (left.val != right.val) return false;
        else return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

// Iterative:
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        ArrayList<TreeNode> left = new ArrayList<>();
        left.add(root.left);
        
        ArrayList<TreeNode> right = new ArrayList<>();
        right.add(root.right);
        
        while (!left.isEmpty() && !right.isEmpty() && left.size() == right.size())
        {
            int size = left.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode l = left.remove(0);
                TreeNode r = right.remove(0);
                if ((l == null && r != null ) || (l != null && r == null) || (l != null && r != null && l.val != r.val)) return false;
                
                if (l != null)
                {
                    left.add(l.left);
                    left.add(l.right);
                }
                if (r != null)
                {
                    right.add(r.right);
                    right.add(r.left);
                }
            }
        }
        
        return left.size() == right.size();
    }
}