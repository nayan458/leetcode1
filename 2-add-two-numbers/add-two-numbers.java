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
        int carry = 0,sum = 0;
        ListNode ptr1 = l1, ptr2 = l2,prev = null,prev2 = null;
        while(ptr1 != null && ptr2 != null) {
            sum = ptr1.val + ptr2.val + carry;
            if(sum > 9){
                carry = 1;
                ptr1.val = sum % 10;
            } else {
                carry = 0;
                ptr1.val = sum;
            }
            prev = ptr1;
            ptr1 = ptr1.next;
            prev2 = ptr2;
            ptr2 = ptr2.next;
        }
        
        if(ptr1 == null ){
            if(ptr2 == null){
                if( carry > 0){
                    ListNode newNode = new ListNode(carry);
                    prev.next = newNode;
                }
            } else {
                prev.next = prev2.next;
                ptr1 = prev.next;
                while(ptr1 != null && carry > 0) {
                    sum = ptr1.val + carry;
                    if( sum > 9){
                        carry = 1;
                        ptr1.val = sum % 10;
                    } else {
                        carry = 0;
                        ptr1.val = sum;
                    }
                    prev = ptr1;
                    ptr1 = ptr1.next;
                }
            }
        } else {
            while(ptr1 != null && carry > 0) {
                    sum = ptr1.val + carry;
                    if( sum > 9){
                        carry = 1;
                        ptr1.val = sum % 10;
                    } else {
                        carry = 0;
                        ptr1.val = sum;
                    }
                    prev = ptr1;
                    ptr1 = ptr1.next;
                }
        }
        if( carry > 0) {
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
        }
        return l1;
    }
}
