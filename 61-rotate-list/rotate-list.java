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
        if(head == null) return head;

        int nodeCount = 1;
        ListNode ptr = head;

        while(ptr.next != null) {
            ptr = ptr.next;
            nodeCount++;
        }

        ptr.next = head;
        k = k % nodeCount;

        // System.out.println(k);
        
        ptr = head;
        // System.out.println("nodeCount: " + nodeCount + " k: " + k + " step: " + (nodeCount - k));   
        for(int i = 0; i < nodeCount - k - 1; i++) 
            ptr = ptr.next;
        // }
            // System.out.println(ptr.val);

        head = ptr.next;
        ptr.next = null;
        return head;
    }
}