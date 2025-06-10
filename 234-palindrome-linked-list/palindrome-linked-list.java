class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;
        ListNode ptr = head;
        String s = "";

        while(ptr != null) {
            String str = Integer.toString(ptr.val);
            s += str;
            ptr = ptr.next;
        }

        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}