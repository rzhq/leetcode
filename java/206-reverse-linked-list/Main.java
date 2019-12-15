// start  2019-12-15 11:06:57
// finish 2019-12-15 11:33:33

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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while ( head != null ) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {});
        check(node);
        node = Connector.connect(new Integer[] {1});
        check(node);
        node = Connector.connect(new Integer[] {1,2});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3,4,5});
        check(node);
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        ListNode ret = s.reverseList(node);
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
