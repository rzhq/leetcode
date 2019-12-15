// start  2019-12-15 10:14:34
// finish 2019-12-15 10:34:09

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        while ( p.next != null) {
            if ( p.next.val == val ) p.next = p.next.next;
            else p = p.next;
        }
        return head.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {1,2,3});
        check(node, 0);
        node = Connector.connect(new Integer[] {});
        check(node, 0);
        node = Connector.connect(new Integer[] {1,2,3,3});
        check(node, 3);
        node = Connector.connect(new Integer[] {3,3});
        check(node, 3);
        node = Connector.connect(new Integer[] {3});
        check(node, 3);
        node = Connector.connect(new Integer[] {3,1,2,3,3,3,4,5,6,3,3,3});
        check(node, 3);
    }
    
    static void check(ListNode node, int val) {
        Solution s = new Solution();
        ListNode ret = s.removeElements(node, val);
        Connector.print(ret);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class Connector {
    public static ListNode connect(Integer[] in) {
        if ( in == null || in.length < 1 ) return null;
        ListNode root = new ListNode(in[0]);
        ListNode node = root;
        for ( int i = 1; i < in.length; i++ ) {
            node.next = new ListNode(in[i]);
            node = node.next;
        }
        return root;
    }
    
    public static void print(ListNode node) {
        while ( node != null ) {
            System.out.printf("%d ", node.val);
            node = node.next;
        }
        System.out.println();
    }
}
