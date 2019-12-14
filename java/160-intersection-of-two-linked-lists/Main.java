// start  2019-12-14 20:22:57
// finish 2019-12-14 21:10:17

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ( headA == null || headB == null ) return null;
        ListNode a = headA, b = headB;
        while ( a != b ) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNodeLen(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int lenA = 0, lenB = 0;
        while ( p != null ) { lenA++; p = p.next; }
        while ( q != null ) { lenB++; q = q.next; }
        p = headA; q = headB;
        while ( lenA > lenB ) { p = p.next; lenA--; }
        while ( lenA < lenB ) { q = q.next; lenB--; }
        while( p != null && q != null ) {
            if ( p == q ) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode a, b;
        a = Connector.connect(new Integer[] {4,1,8,4,5});
        b = Connector.connect(new Integer[] {5,0,1,8,4,5});
        check(a, b, 2, 3);
        a = Connector.connect(new Integer[] {4,1,8,1,1});
        b = Connector.connect(new Integer[] {5,0,1,8,4,5});
        check(a, b, -1, -1);
        a = Connector.connect(new Integer[] {});
        b = Connector.connect(new Integer[] {5,0,1,8,4,5});
        check(a, b, -1, -1);
        a = Connector.connect(new Integer[] {1,2});
        b = Connector.connect(new Integer[] {1,2});
        check(a, b, 1, 1);
    }
    
    static void check(ListNode a, ListNode b, int sa, int sb) {
        Solution s = new Solution();
        ListNode ap = a, bp = b;
        sb--;
        while ( sa > 0 && ap != null ) { ap = ap.next; sa--; }
        while ( sb > 0 && bp != null ) { bp = bp.next; sb--; }
        if ( bp != null && ap != null && sa == 0 && sb == 0 ) bp.next = ap;
        ListNode n = s.getIntersectionNode(a, b);
        System.out.printf("%d %d\n",
            n == null ? null : n.val,
            sa < 0 && sb < 0 ? null : ap == null ? null : ap.val
        );
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
