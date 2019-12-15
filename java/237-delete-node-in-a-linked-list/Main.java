// start  2019-12-15 12:20:29
// finish 2019-12-15 12:38:47

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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {1,2,3});
        check(node, 2);
        node = Connector.connect(new Integer[] {1,2,3,4});
        check(node, 1);
    }
    
    static void check(ListNode node, int val) {
        Solution s = new Solution();
        ListNode head = node;
        ListNode n = node;
        while ( n != null && n.val != val ) n = n.next;
        s.deleteNode(n);
        Connector.print(head);
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
