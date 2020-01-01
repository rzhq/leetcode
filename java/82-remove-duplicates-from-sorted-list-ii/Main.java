// start    2020-01-01 14:48:09
// finish   2020-01-01 15:06:43

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0), p = pre, q = head;
        pre.next = head;
        while ( q != null && q.next != null ) {
            if ( q.val == q.next.val ) {
                while ( q.next != null && q.val == q.next.val ) q.next = q.next.next;
                p.next = q.next;
            } else p = q;
            q = q.next;
        }
        return pre.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {});
        check(node);
        node = Connector.connect(new Integer[] {1});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3,3,4,4});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3,3,4,4,5});
        check(node);
        node = Connector.connect(new Integer[] {1,1,1,2,3});
        check(node);
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        ListNode ret = s.deleteDuplicates(node);
        Connector.print(ret);
        System.out.println();
    }
}
