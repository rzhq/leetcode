// start    2019-12-30 16:10:44
// finish   2019-12-30 16:46:28

import java.util.*;

class Solution {
    public Node connect(Node root) {
        iterative(root);
        return root;
    }

    void iterative(Node n) {
        Node head = null, prev = null;
        while ( n != null ) {
            while ( n != null ) {
                if ( n.left != null ) {
                    if ( prev != null ) prev.next = n.left;
                    else head = n.left;
                    prev = n.left;
                }
                if ( n.right != null ) {
                    if ( prev != null ) prev.next = n.right;
                    else head = n.right;
                    prev = n.right;
                }
                n = n.next;
            }
            n = head;
            head = null;
            prev = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Node n = new Node(1);
        check(n);
    }

    static void check(Node n) {
        Solution s = new Solution();
        System.out.printf("\n");
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
