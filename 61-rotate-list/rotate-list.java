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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null)
            return head;

        // calculate number of nodes
        int n = 1;
        ListNode ptr = head;
        
        while(ptr.next != null){
            n++;
            ptr = ptr.next;
        }
        // connect the end to the begin
        ptr.next = head;
        // calculate the cut
        k = k % n; // number of rotations
        k = n - k; // this k is the node that we will detech
        ptr = head;

        System.out.println(k);
        while(k-- != 1) {
            ptr = ptr.next;
            System.out.printf("ptr.val: %d, k: %d\n",ptr.val,k);
        }

        head = ptr.next;
        ptr.next = null;

        return head;
    }
}