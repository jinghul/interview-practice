// SOLUTION 1: interweave pointers
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Node curr = head;
        while (curr != null)
        {
            Node copy = new Node(curr.val, curr.next, curr);
            curr.next = copy;
            curr = copy.next;
        }
        
        Node copyHead = head.next;
        curr = head.next;
        while (curr != null)
        {
            Node random = curr.random.random;
            curr.random = random == null ? null : random.next;
            if (curr.next != null) curr = curr.next.next;
            else break;
        }
        
        curr = head;
        while (curr != null && curr.next != null)
        {
            Node next = curr.next;
            curr.next = curr.next.next;
            curr = next;
        }
        
        return copyHead;
    }
}


// SOLUTION 2: HASHMAP

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node prev = null;
        while (curr != null)
        {
            Node copy = new Node(curr.val, null, curr.random);
            if (prev != null) prev.next = copy;
            prev = copy;
            map.put(curr, copy);
            curr = curr.next;
        }
        
        head = map.get(head);
        curr = head;
        while (curr != null)
        {
            curr.random = map.get(curr.random);
            curr = curr.next;
        }
        
        return head;
    }
}