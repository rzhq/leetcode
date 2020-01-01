// start    2020-01-01 20:48:57
// finish   2020-01-01 21:28:10

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if ( head == null ) return head;
        ListNode pre = new ListNode(0), p1 = pre, p2, p3;
        pre.next = head;
        n -= m;
        while ( --m != 0 ) p1 = p1.next;
        p2 = p1.next;
        while ( n-- != 0 ) {
            p3 = p2.next;
            p2.next = p2.next.next;
            p3.next = p1.next;
            p1.next = p3;
        }
        return pre.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {1,2,3,4,5});
        check(node, 2, 4);
        node = Connector.connect(new Integer[] {1,2,3,4,5});
        check(node, 1, 5);
        node = Connector.connect(new Integer[] {1,2,3,4,5});
        check(node, 3, 3);
        node = Connector.connect(new Integer[] {1,2,3,4,5});
        check(node, 3, 5);
        node = Connector.connect(new Integer[] {1,2,3,4,5});
        check(node, 1, 3);
        node = Connector.connect(new Integer[] {1,2});
        check(node, 1, 2);
    }
    
    static void check(ListNode node, int m, int n) {
        Solution s = new Solution();
        ListNode ret = s.reverseBetween(node, m, n);
        Connector.print(ret);
    }
}
