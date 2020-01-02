// start    2020-01-02 13:07:03
// finish   2020-01-02 13:13:21

import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) break;
        }
        if ( fast == null || fast.next == null ) return null;
        slow = head;
        while ( slow != fast ) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

public class Main {
    public static void main(String[] args) {
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        System.out.println();
    }
}
