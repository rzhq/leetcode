// start    2020-01-01 15:26:23
// finish   2020-01-01 15:56:26

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
    public ListNode partition(ListNode head, int x) {
        //return s1(head, x);
        return s2(head, x);
    }

    ListNode s2(ListNode head, int x) {
        ListNode n1 = new ListNode(0), n2 = new ListNode(0);
        ListNode p1 = n1, p2 = n2;
        while ( head != null ) {
            if ( head.val < x ) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = n2.next;
        return n1.next;
    }

    ListNode s1(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre, tmp;
        while ( p.next != null && p.next.val < x ) p = p.next;
        ListNode q = p;
        while ( q.next != null ) {
            while ( q.next != null && q.next.val >= x ) q = q.next;
            if ( q.next == null ) break;
            tmp = p.next;
            p.next = q.next;
            q.next = q.next.next;
            p.next.next = tmp;
            p = p.next;
        }
        return pre.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {1});
        check(node, 4);
        node = Connector.connect(new Integer[] {1,2,3,4,5,6});
        check(node, 4);
        node = Connector.connect(new Integer[] {1,2,3,4,5,6});
        check(node, 6);
        node = Connector.connect(new Integer[] {1,2,3,4,5,6,1,2,3,4,5,6});
        check(node, 4);
    }
    
    static void check(ListNode node, int x) {
        Solution s = new Solution();
        ListNode ret = s.partition(node, x);
        Connector.print(ret);
    }
}
