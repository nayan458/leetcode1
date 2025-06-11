class Solution {

    // Helper method to insert a node into the correct position in a sorted list
    private ListNode insert(ListNode head, ListNode node) {
        if (head == null || node == null) return head;

        // If the node should be the new head
        if (node.val <= head.val) {
            node.next = head;
            return node;
        }

        ListNode ptr = head;

        // Traverse to find correct insertion point
        while (ptr.next != null && ptr.next.val < node.val) {
            ptr = ptr.next;
        }

        // Insert node after ptr
        node.next = ptr.next;
        ptr.next = node;

        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;

        ListNode ptr = head;
        ListNode cur = head.next;

        // Mark end of sorted list (initially the first node)
        ptr.next = null;

        while (cur != null) {
            ListNode next = cur.next;   // Store next node
            cur.next = null;            // Disconnect current node
            head = insert(head, cur);   // Insert into sorted list
            cur = next;                 // Move to next
        }

        return head;
    }
}
