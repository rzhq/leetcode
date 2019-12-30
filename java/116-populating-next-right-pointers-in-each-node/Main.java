// start    2019-12-30 15:16:43
// finish   2019-12-30 16:08:29

import java.util.*;

class Solution {
    public Node connect(Node root) {
        //iterative(root);
        recursive(root);
        return root;
    }

    void recursive(Node root) {
        if ( root == null || root.left == null ) return;
        root.left.next = root.right;
        if ( root.next != null ) root.right.next = root.next.left;
        recursive(root.left);
        recursive(root.right);
    }

    void iterative(Node n) {
        while ( n != null && n.left != null ) {
            Node p = n;
            while ( p != null ) {
                p.left.next = p.right;
                if ( p.next != null ) p.right.next = p.next.left;
                p = p.next;
            }
            n = n.left;
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
