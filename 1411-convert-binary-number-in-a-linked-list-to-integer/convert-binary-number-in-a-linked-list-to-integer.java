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
    public int getDecimalValue(ListNode head) {
        int count = -1;

        while(head != null && head.val == 0) {
            head = head.next;
        }
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            ++count;
        }
        
        ptr = head;
        int result = 0;
        while (ptr != null) {
            if(ptr.val == 1)
                result += Math.pow(2,count);
            ptr = ptr.next;
            --count;
        }

        return result;
    }
}