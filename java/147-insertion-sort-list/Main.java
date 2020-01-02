// start    2020-01-02 15:18:47
// finish   2020-01-02 15:39:54

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
    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(0), p;
        while ( head != null ) {
            p = pre;
            ListNode t = head;
            head = head.next;
            while ( p.next != null && p.next.val < t.val ) p = p.next;
            t.next = p.next;
            p.next = t;
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
        node = Connector.connect(new Integer[] {2,1});
        check(node);
        node = Connector.connect(new Integer[] {2,1,3,3,1,2});
        check(node);
        node = Connector.connect(new Integer[] {1,4,5,2,3});
        check(node);
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        ListNode ret = s.insertionSortList(node);
        Connector.print(ret);
    }
}
