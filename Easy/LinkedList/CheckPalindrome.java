/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        
        ListNode curr = head;
        int count = 0;
        while (curr != null)
        {
            count++;
            curr = curr.next;
        }
        
        if (count == 1) return true;
        
        curr = head;
        ListNode next = head.next;
        for (int i = 0; i < (count + 1) / 2; i++)
        {
            curr = curr.next;
            next = next.next;
        }
        
        ListNode prev = null;
        while (curr != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            
            if (next != null) next = next.next;
        }
        
        curr = prev;
        prev = head;
        for (int i = 0; i < count / 2; i++)
        {
            if (curr.val != prev.val)
            {
                return false;
            }
            curr = curr.next;
            prev = prev.next;
        }
        
        return true;
    }
}