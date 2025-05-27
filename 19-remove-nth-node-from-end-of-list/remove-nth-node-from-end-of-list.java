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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode ptr = head;

        // count number of nodes
        while(ptr != null) {
            ++sz;
            ptr = ptr.next;
        }

        int k = (sz - n + 1);
        
        if(sz == 1 || k == 1)
            return head.next;

        ptr = head;
        ListNode temp = head;

        while( k != 1) {
            temp = ptr;
            ptr = ptr.next;
            k--;
        }
        ptr = ptr == null ? null : ptr.next;
        temp.next = ptr;
        
        return head;
    }
}