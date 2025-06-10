
// SOLUTION: I
// USING STRING

// Traverse the list and convert into a single string O(n)
// Traverse the string and check for palindrom        O(n)
// Time Complaxity: O(n)

// class Solution {
//     public boolean isPalindrome(ListNode head) {

//         if(head == null || head.next == null)
//             return true;
//         ListNode ptr = head;
//         String s = "";

//         while(ptr != null) {
//             String str = Integer.toString(ptr.val);
//             s += str;
//             ptr = ptr.next;
//         }

//         int left = 0, right = s.length() - 1;

//         while(left < right) {
//             if(s.charAt(left) != s.charAt(right))
//                 return false;
//             left++;
//             right--;
//         }

//         return true;
//     }
// }


// SOLUTION: II
// SPLITING THE LIST AND REVERSING IT

// find the mid O(n/2)
// split in two O(1)
// reverse the sencond list O(n/2)
// compare the two list O(n/2)
// Time Complexity O(n/2) = O(n)

class Solution {
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverse(slow.next);
        
        // Compare
        while (secondHalf != null) {
            if (head.val != secondHalf.val) return false;
            head = head.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
}