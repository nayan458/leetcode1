class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1);
        Set<Integer> set = new HashSet<>();
        for(int elem: nums)
            set.add(elem);
        
        ListNode ptr = head;
        ListNode dummyPtr = dummy;

        while(ptr != null){
            if(set.contains(ptr.val)){
                ptr = ptr.next;
                continue;
            }
            dummyPtr.next = ptr;
            dummyPtr = ptr;
            ptr = ptr.next;
        }
        dummyPtr.next = null;
        return dummy.next;
    }
    
}