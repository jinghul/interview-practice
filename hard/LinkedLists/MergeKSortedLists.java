// Solution 1: PriorityQueue = Nlogk

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        else if (lists.length == 1) return lists[0];
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x1, x2) -> x1.val - x2.val);
        for (ListNode ln : lists) {
            if (ln != null) pq.add(ln);
        }
        
        while (!pq.isEmpty())
        {
            ListNode next = pq.poll();
            curr.next = next;
            curr = curr.next;
            if (next.next != null) pq.add(next.next);
        }
        
        return head.next;
    }
}

// Solution 2: sort each time = O(Nklogk)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        else if (lists.length == 1) return lists[0];
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        Arrays.sort(lists, (n1, n2) -> {
            if (n1 == null && n2 == null) return 0;
            else if (n1 == null) return 1;
            else if (n2 == null) return -1;
            else return n1.val - n2.val;
        });
        
        while (lists[0] != null)
        {
            curr.next = lists[0];
            curr = curr.next;
            lists[0] = lists[0].next;
            
            Arrays.sort(lists, (n1, n2) -> {
                if (n1 == null && n2 == null) return 0;
                else if (n1 == null) return 1;
                else if (n2 == null) return -1;
                else return n1.val - n2.val;
            });
        }
        
        return head.next;
    }
}