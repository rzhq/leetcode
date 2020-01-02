// start    2020-01-02 16:41:25
// finish   2020-01-02 17:07:03

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
    public ListNode sortList(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode pre = new ListNode(0), p;
        ListNode fast = head.next, slow = head;
        while ( fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        p = slow.next;
        slow.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(p);
        p = pre;
        while ( n1 != null && n2 != null ) {
            if ( n1.val < n2.val ) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if ( n1 != null ) p.next = n1;
        else if ( n2 != null ) p.next = n2;
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
        node = Connector.connect(new Integer[] {2,1});
        check(node);
        node = Connector.connect(new Integer[] {2,3,1});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3,6,4,5,3});
        check(node);
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        ListNode ret = s.sortList(node);
        Connector.print(ret);
    }
}
