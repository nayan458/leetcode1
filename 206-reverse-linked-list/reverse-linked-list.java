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
    public ListNode reverseList(ListNode head) {
        ListNode left = head, right = head != null ? head.next : null;

        while(right != null) {
            if(head == left) 
                head.next = null;
            else {
                left.next = head;
                head = left;
            }
            left = right;
            right = right.next;
            left.next = head;
        }

        return left;
    }
}