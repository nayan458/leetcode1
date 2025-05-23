class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ptr = l1, pre_ptr = ptr;
        while(ptr != null && l2 != null) {
            ptr.val = (ptr.val + l2.val + carry);
            if(ptr.val > 9) {
                carry = ptr.val/10;
                ptr.val %= 10;
            } else
                carry = 0;
            pre_ptr = ptr;
            ptr = ptr.next;
            l2 = l2.next;
        }
        
        if(l2 != null || ptr != null){
            pre_ptr.next = l2 != null ? l2 : ptr;
            ptr = l2 != null? l2 : ptr;
            while(carry != 0 && ptr != null){
                ptr.val += carry;
                carry = ptr.val/10;
                ptr.val %= 10;

                pre_ptr = ptr;
                ptr = ptr.next;
            }
        }

        if(carry != 0)
            pre_ptr.next = new ListNode(carry);




        return l1;
    }
}