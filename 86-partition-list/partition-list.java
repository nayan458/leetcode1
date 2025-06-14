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
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null)
            return head;
        // create a dummy node before head
        ListNode ptr = new ListNode();
        ptr.next = head;
        head = ptr;

        ListNode dummy = new ListNode(),pre = head, ptr2;
        ptr = ptr.next;
        ptr2 = dummy;

        while(ptr != null) {
            if(ptr.val < x) {
                ptr2.next = ptr;
                pre.next = ptr.next;
                ptr.next = null;
                ptr2 = ptr2.next;
                ptr = pre.next;
                continue;
            }
            pre = ptr;
            ptr = ptr.next;
        }
        ptr2.next = head.next;
        return dummy.next;
        
    }
}