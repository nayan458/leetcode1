class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null) 
            return head;

        ListNode ptr1 = head, ptr2 = head.next, temp = head.next.next;
        ptr2.next = ptr1;
        head = ptr2;
        ptr1.next = swapPairs(temp);


        return head;
    }
}