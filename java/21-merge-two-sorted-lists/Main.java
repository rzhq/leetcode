// start  2019-12-14 18:25:23
// finish 2019-12-14 18:45:09

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        if ( l1.val < l2.val ) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public ListNode mergeTwoListsLoop(ListNode l1, ListNode l2) {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        ListNode root = new ListNode(0);
        ListNode p = root;
        while ( l1 != null && l2 != null ) {
            if ( l1.val < l2.val ) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if ( l1 == null ) p.next = l2;
        if ( l2 == null ) p.next = l1;
        return root.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode l1, l2;
        l1 = Connector.connect(new Integer[] {});
        l2 = Connector.connect(new Integer[] {1,2,3});
        check(l1, l2);
        l1 = Connector.connect(new Integer[] {1,2,3});
        l2 = Connector.connect(new Integer[] {1,2,3});
        check(l1, l2);
        l1 = Connector.connect(new Integer[] {1,2,3});
        l2 = Connector.connect(new Integer[] {2,2,3,4,5});
        check(l1, l2);
    }
    
    static void check(ListNode l1, ListNode l2) {
        Solution s = new Solution();
        ListNode ret = s.mergeTwoLists(l1, l2);
        Connector.print(ret);
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
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
