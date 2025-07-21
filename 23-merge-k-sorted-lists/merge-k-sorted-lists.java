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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val,b.val)
        );

        for(ListNode elem: lists){
            while(elem != null){
                heap.add(elem);
                elem = elem.next;
            }
            System.out.println();
        }

        ListNode head = heap.poll();
        ListNode ptr = head;

        while(!heap.isEmpty()){
            ptr.next = heap.poll();
            ptr = ptr.next;
        }
        if(ptr != null)
            ptr.next = null;
        else
            ptr = null;

        return head;
    }
}