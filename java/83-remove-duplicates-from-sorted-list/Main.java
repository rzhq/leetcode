// start  2019-12-14 18:45:50
// finish 2019-12-14 18:50:50

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
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null ) return null;
        ListNode p = head;
        while ( p.next != null ) {
            if ( p.val == p.next.val ) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {1,2,2,2,3,3,4});
        check(node);
        node = Connector.connect(new Integer[] {});
        check(node);
        node = Connector.connect(new Integer[] {1});
        check(node);
        node = Connector.connect(new Integer[] {1,1});
        check(node);
        node = Connector.connect(new Integer[] {1,2,2});
        check(node);
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        ListNode ret = s.deleteDuplicates(node);
        Connector.print(ret);
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
