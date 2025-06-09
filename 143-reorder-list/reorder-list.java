class Solution {

    public ListNode partition(ListNode l1_head) {

        ListNode ptr = l1_head, pre_ptr = ptr, l2_head = null;
        ptr = ptr.next;
        
        while(ptr != null && ptr.next != null) {
            pre_ptr = pre_ptr.next;
            ptr = ptr.next.next;
        }

        l2_head = pre_ptr.next;
        pre_ptr.next = null;

        return l2_head;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // store next node
            current.next = prev;              // reverse the link
            prev = current;                   // move prev one step
            current = nextNode;               // move current one step
        }

        return prev; // new head of reversed list
    }

    public void print(ListNode head) {
        while(head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        ListNode l1_head = head, l2_head = null;

        // Partition
        l2_head = partition(l1_head);

        // Reverse
        l2_head = reverse(l2_head);

        // Merge
        ListNode pre_ptr1 = l1_head, pre_ptr2 = l2_head;
        ListNode ptr1 = l1_head != null ? l1_head.next : null;
        ListNode ptr2 = l2_head != null ? l2_head.next : null;
        
        while(ptr2 != pre_ptr2) {

            // adjusting the pre_ptr1
            pre_ptr1.next = pre_ptr2;
            pre_ptr1 = ptr1;

            // adjusting the pre_ptr2
            pre_ptr2.next = ptr1;
            pre_ptr2 = ptr2;

            // adjusting the ptr1
            ptr1 = ptr1 != null ? ptr1.next : null;
            ptr2 = ptr2 != null ? ptr2.next : null;
        }
    }
}