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
    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();

        while(head != null) {
            values.add(head.val);
            head = head.next;
        }

        int n = values.size();
        int max = IntStream.range(0,n/2)
                            .map(i -> values.get(i) + values.get(n-i-1))
                            .max()
                            .orElse(0);
        return max;
                            
    }
}