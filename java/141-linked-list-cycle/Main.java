// start  2019-12-14 18:51:24
// finish 2019-12-14 19:40:58

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
    public boolean hasCycle(ListNode head) {
        if ( head == null ) return false;
        ListNode p = head;
        ListNode q = head;
        while ( q.next != null && q.next.next != null ) {
            p = p.next;
            q = q.next.next;
            if ( p == q ) return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {1,2,3,4,5,6});
        check(node, 1);
        node = Connector.connect(new Integer[] {1,2,3,4,5,6});
        check(node, -1);
        node = Connector.connect(new Integer[] {});
        check(node, -1);
        node = Connector.connect(new Integer[] {1});
        check(node, 0);
        node = Connector.connect(new Integer[] {1,2,3});
        check(node, 0);
    }
    
    static void check(ListNode node, int pos) {
        if ( pos != -1 ) {
            ListNode p = node;
            ListNode posNode = node;
            int c = pos;
            while ( p.next != null ) {
                c--; p = p.next;
                if ( c == 0 ) posNode = p;
            }
            p.next = posNode;
        }
        Solution s = new Solution();
        boolean ret = s.hasCycle(node);
        System.out.printf("%s %s\n", ret, pos!=-1);
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
