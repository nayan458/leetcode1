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
            if(elem != null)
                heap.add(elem);
        }
        ListNode head = heap.poll(), ptr = head;
        if(head != null && head.next != null)
            heap.add(head.next);

        while(!heap.isEmpty()){
            ptr.next = heap.poll();
            ptr = ptr.next;
            if(ptr.next != null)
                heap.add(ptr.next);
        }

        if(ptr != null)
            ptr.next = null;

        return head;
    }
}

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<ListNode> heap = new PriorityQueue<>(
//             (a,b) -> Integer.compare(a.val,b.val)
//         );

//         for(ListNode elem: lists){
//             while(elem != null){
//                 heap.add(elem);
//                 elem = elem.next;
//             }
//             System.out.println();
//         }

//         ListNode head = heap.poll();
//         ListNode ptr = head;

//         while(!heap.isEmpty()){
//             ptr.next = heap.poll();
//             ptr = ptr.next;
//         }

//         if(ptr != null)
//             ptr.next = null;

//         return head;
//     }
// }