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
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfCurrent = head;

        boolean isPal = true;
        while (secondHalfHead != null) {
            if (firstHalfCurrent.val != secondHalfHead.val) {
                isPal = false;
                break;
            }
            firstHalfCurrent = firstHalfCurrent.next;
            secondHalfHead = secondHalfHead.next;
        }

        return isPal;
    }
        
        

        }         
    