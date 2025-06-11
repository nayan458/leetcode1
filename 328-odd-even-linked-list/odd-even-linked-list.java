/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode odd = head, even = head.next;
        ListNode optr = odd, eptr = even;

        while(eptr != null && eptr.next != null) {
            
            optr.next = eptr.next;
            optr = optr.next;

            eptr.next = optr.next;
            eptr = eptr.next;
        }

        optr.next = even;

        System.gc();
        return odd;

    }
}