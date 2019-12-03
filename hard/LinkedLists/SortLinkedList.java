/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        else if (head.next == null) return head;
        
        ListNode bef = new ListNode(0);
        bef.next = head;
        
        ListNode slow = bef;
        ListNode fast = bef;
        
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null);
        
        fast = slow.next;
        slow.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(fast);
        return mergeLists(l1, l2);
    }
    
    // public ListNode sortList(ListNode head, )
    
    public ListNode mergeLists(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 == null)
        {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        return head.next;
    }
}