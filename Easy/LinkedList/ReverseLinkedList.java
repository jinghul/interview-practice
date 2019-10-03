/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        
        while (curr != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            
            if (next != null) next = next.next;
        }
        
        return prev;
    }
}

/**
 Recursive solution
 */
class Solution1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }
    
    public ListNode reverseList(ListNode prev, ListNode curr)
    {
        if (curr == null)
        {
            return prev;
        } else {
            ListNode next = curr.next;
            curr.next = prev;
            return reverseList(curr, next);
        }
    }
}