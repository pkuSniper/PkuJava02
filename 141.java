/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode p = head, q = head;
        while(true)
        {
            if(p==null || q==null || q.next==null)
                return false;
            p = p.next;
            q = q.next.next;
            if(p == q)
                return true;
        }
    }
}