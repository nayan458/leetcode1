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
    public ListNode removeElements(ListNode head, int val) {
        ListNode ptr = head, pre_ptr = head;

        while(ptr != null) {
            if(ptr.val == val)
                if(ptr == head) {
                    ptr = ptr.next;
                    head = head.next;
                    pre_ptr = ptr;
                }
                else {
                    ptr = ptr.next;
                    pre_ptr.next = ptr;
                }
            else {
                pre_ptr = ptr;
                ptr = ptr.next;
            }
        }

        return head;
    }
}