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

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // base case
        if(left == right || head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;
        ListNode ptr = head, lptr = head, rptr = head, temp = head, pre = head;

        for(int i = 1; i < left + 1; i++){
            lptr = ptr;
            ptr = ptr.next;
        }

        for(int i = 1; i < right + 1 - left; i++)
            ptr = ptr.next;
        rptr = ptr;

        rptr = ptr.next;
        ptr.next = null;
        
        lptr.next = reverse(lptr.next);
        
        while(ptr.next != null)
            ptr = ptr.next;
        ptr.next = rptr;
        
        return dummy.next;
    }
}