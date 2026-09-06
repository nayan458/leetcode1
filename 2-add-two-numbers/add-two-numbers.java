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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;

        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum/10;
            dummy.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            dummy = dummy.next;
        }

        while(l1 != null) {
            sum = l1.val + carry;
            carry = sum/10;
            dummy.next = new ListNode(sum % 10);
            l1 = l1.next;
            dummy = dummy.next;
        }

        while(l2 != null) {
            sum = l2.val + carry;
            carry = sum/10;
            dummy.next = new ListNode(sum % 10);
            l2 = l2.next;
            dummy = dummy.next;
        }

        if(carry != 0)
            dummy.next = new ListNode(1);
        

        return dummyHead.next;
    }
}