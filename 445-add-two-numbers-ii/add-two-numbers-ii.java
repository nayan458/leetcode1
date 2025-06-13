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
    private void printll(ListNode head) {
        while(head != null){
            System.out.printf("%d\t",head.val);
            head = head.next;
        }
        System.out.println();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ptr1 = l1, ptr2 = l2;
        // make linked list equal
        while(ptr1.next != null && ptr2.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        if(ptr1.next != ptr2.next)
            if(ptr1.next == null){
                while(ptr2.next != null) {
                    ptr2 = ptr2.next;
                    ListNode temp = new ListNode();
                    temp.next = l1;
                    l1 = temp;
                }
            } else {
                while(ptr1.next != null) {
                    ptr1 = ptr1.next;
                    ListNode temp = new ListNode();
                    temp.next = l2;
                    l2 = temp;
                }
            }

        // reset ptr
        ptr1 = l1;
        ptr2 = l2;
        printll(l1);
        printll(l2);
        // return l2;
        // sum carry
        boolean flag = true;
        int pass = 1;
        while(flag) {
            System.out.printf("Pass: %d\n", pass);
            flag = false;
            pass++;
            printll(l1);
            printll(l2);
            while(ptr1.next != null) {
                int sum = ptr1.val + ptr2.val;
                ptr1.val = sum % 10;
                ptr2.val = sum / 10;
                // System.out.printf("ptr1.val: %d, ptr2.val: %d, sum: %d\n",ptr1.val,ptr2.val, sum);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                
                if(sum/10 > 0)
                    flag = true;    
            }
            // cleanup
            int sum = ptr1.val + ptr2.val;
            // System.out.printf("ptr1.val: %d, ptr2.val: %d, sum: %d\n",ptr1.val,ptr2.val, sum);
            ptr1.val = sum % 10;
            ptr2.val = sum / 10;
            if(sum/10 > 0)
                flag = true;    
            ptr2.next = new ListNode();
            ptr2 = ptr2.next;
            // if carry at head detech and attach
            if(l2.val > 0){
                ptr2 = l2.next;
                l2.next = l1;
                l1 = l2;
                ListNode temp = new ListNode();
                temp.next = ptr2;
                l2 = temp;
            }
            // else head = head.next and add a node at the end
            else {
                l2 = l2.next;
            }
            ptr1 = l1;
            ptr2 = l2;
        }

        return l1;
    }
}