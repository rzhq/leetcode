// start  2019-12-15 11:34:17
// finish 2019-12-15 12:09:13

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
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while ( p != null ) { len++; p = p.next; }
        if ( len < 2 ) return true;
        if ( len == 2 ) return head.val == head.next.val;
        int i = len / 2 - 1;
        p = null;
        ListNode q = head.next;
        for ( int k = 0; k <= i; k++ ) {
            head.next = p;
            p = head;
            head = q;
            q = q.next;
        }
        if ( len % 2 == 0 ) q = head;
        while ( p != null && q != null ) {
            if ( p.val != q.val ) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {});
        check(node, true);
        node = Connector.connect(new Integer[] {1});
        check(node, true);
        node = Connector.connect(new Integer[] {1,1});
        check(node, true);
        node = Connector.connect(new Integer[] {1,2,3,2,1});
        check(node, true);
        node = Connector.connect(new Integer[] {1,2,3,3,2,1});
        check(node, true);
        node = Connector.connect(new Integer[] {1,2});
        check(node, false);
        node = Connector.connect(new Integer[] {1,2,3,4,2,1});
        check(node, false);
        node = Connector.connect(new Integer[] {2,2,3,3,2,1});
        check(node, false);
    }
    
    static void check(ListNode node, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isPalindrome(node);
        System.out.printf("%s %s\n", ret, out);
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
