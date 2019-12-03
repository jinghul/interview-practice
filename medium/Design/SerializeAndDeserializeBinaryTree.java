/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node == null) sb.append("#,");
            else {
                sb.append(node.val);
                sb.append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        LinkedList<String> squeue = new LinkedList<>(Arrays.asList(data.split(",")));
        LinkedList<TreeNode> nqueue = new LinkedList<>();
        
        TreeNode root = new TreeNode(Integer.valueOf(squeue.poll()));
        nqueue.add(root);
        
        // System.out.println(data);
        
        while (!nqueue.isEmpty() && !squeue.isEmpty())
        {
            TreeNode node = nqueue.poll();
            String left = squeue.poll();
            String right = squeue.poll();
            
            if (!left.equals("#"))
            {
                node.left = new TreeNode(Integer.valueOf(left));
                nqueue.add(node.left);
            }
            if (!right.equals("#"))
            {
                node.right = new TreeNode(Integer.valueOf(right));
                nqueue.add(node.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        ArrayList<TreeNode> queue = new ArrayList<>();
        int nodes = 0;
        
        if (root != null)
        {
            nodes = 1;
            queue.add(root);
        }
        
        while (!queue.isEmpty() && nodes > 0)
        {
            TreeNode curr = queue.remove(0);
            if (curr != null) {
                nodes--;
                if (curr.left != null) nodes++;
                queue.add(curr.left);
                if (curr.right != null) nodes++;
                queue.add(curr.right);
            }
        
            String val = curr == null ? "null," : curr.val + ",";
            builder.append(val);
        }
        
        if (builder.length() > 0) builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 1) return null;
        String[] vals = data.split(",");
        TreeNode[] nodes = new TreeNode[vals.length];
        nodes[0] = new TreeNode(Integer.valueOf(vals[0]));
        
        int count = 1;
        for (int i = 1; i < vals.length; i++)
        {
            String val = vals[i];
            System.out.println(val);
            if (val.equals("null")) continue;
            TreeNode node = new TreeNode(Integer.valueOf(val));
            TreeNode parent = nodes[(i+1) / 2 - 1];
            if (i % 2 == 0) parent.right = node;
            else parent.left = node;
            nodes[count++] = node;
        }
        
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));