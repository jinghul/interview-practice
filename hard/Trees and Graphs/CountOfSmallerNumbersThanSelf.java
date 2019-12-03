// Solution 1: AVL Tree and keep count of passing elements
class Solution {
    class Node
    {
        Node left, right;
        int height, val;
        int size, count;
        
        public Node(int val)
        {
            this.val = val;
            this.size = 1;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        if (nums.length == 0) return result;
        
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            Node elem = new Node(nums[i]);
            root = insert(root, elem);
            result.add(0, elem.count);
        }
        return result;
    }
    
    public Node leftRotate(Node x)
    {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        
        // update heights
        x.height = updateHeight(x);
        y.height = updateHeight(y);
        
        return y;
    }

    public Node rightRotate(Node x)
    {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        
        // update heights
        x.height = updateHeight(x);
        y.height = updateHeight(y);
        
        return y;
    }
    
    public int updateHeight(Node x)
    {
        x.size = size(x.left) + size(x.right) + 1;
        return 1 + Math.max(height(x.right), height(x.left));
    }
    
    public int size(Node x)
    {
        if (x == null) return 0;
        return x.size;
    }
    
    public int height(Node x)
    {
        if (x == null) return -1;
        return x.height;
    }
    
    public Node insert(Node root, Node elem)
    {
        if (root == null) return elem;
        else if (elem.val <= root.val)
        {
            root.left = insert(root.left, elem);
        } else { // greater
            elem.count += size(root.left) + 1;
            root.right = insert(root.right, elem);
        }
        
        // increment size by 1
        root.size++;
        
        // balance tree through rotations
        int balance = height(root.left) - height(root.right);
        
        if (balance < -1)
        {
            // right heavy
            if (elem.val <= root.right.val)
            {
                // less than right child = right left
                root.right = rightRotate(root.right);
            }
            
            // greater or equal than right child = right right
            return leftRotate(root);
        } else if (balance > 1)
        {
            // left heavy
            if (elem.val > root.left.val)
            {
                // greater than left child = left right
                root.left = leftRotate(root.left);
            }
            return rightRotate(root);
        }
        
        // no rotations necessary
        root.height = updateHeight(root);
        return root;
    }
}

// Solution 2: Not balanced (faster for leetcode)
class Solution {
    
    class Node
    {
        Node left, right;
        int val, size, count;
        
        public Node(int val)
        {
            this.val = val;
            this.size = 1;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        if (nums.length == 0) return result;
        
        Node root = new Node(nums[nums.length - 1]);
        result.add(0);
        
        for (int i = nums.length - 2; i >= 0; i--)
        {
            result.add(0, insert(root, nums[i]));
        }
        return result;
    }
    
    public int size(Node x)
    {
        if (x == null) return 0;
        return x.size;
    }
    
    public int insert(Node root, int num)
    {
        int greater = 0;
        Node curr = root;
        Node elem = new Node(num);
        
        while (curr != null)
        {
            curr.size++;
            if (curr.val < num)
            {
                greater += size(curr.left) + 1;
                if (curr.right == null) {
                    curr.right = elem;
                    break;
                }
                else curr = curr.right;
            } else {
                if (curr.left == null) 
                {
                    curr.left = elem;
                    break;
                }
                else curr = curr.left;
            }
        }
        
        return greater;
    }
}