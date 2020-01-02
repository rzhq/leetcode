// start    2020-01-02 12:21:02
// finish   2020-01-02 12:30:39

import java.util.*;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        //return NSpace(head);
        return CSpace(head);
    }

    Node CSpace(Node head) {
        Node p = head, pre = new Node(0), q;
        while ( p != null ) {
            Node t = p.next;
            p.next = new Node(p.val);
            p.next.next = t;
            p = t;
        }
        p = head;
        while ( p != null ) {
            if ( p.random != null ) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        q = pre;
        while ( p != null ) {
            Node t = p.next;
            p.next = p.next.next;
            q.next = t;
            p = p.next;
            q = q.next;
        }
        return pre.next;
    }

    Node NSpace(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node n1 = new Node(0), n2 = new Node(0);
        Node p1 = n1, p2 = n2;
        n1.next = head;
        while ( p1.next != null ) {
            p2.next = new Node(p1.next.val);
            map.put(p1.next, p2.next);
            p1 = p1.next;
            p2 = p2.next;
        }
        p1 = n1;
        p2 = n2;
        while ( p1.next != null ) {
            p2.next.random = map.get(p1.next.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        return n2.next;
    }
}

public class Main {
    public static void main(String[] args) {
    }
    
    static void check(Node node) {
        Solution s = new Solution();
        System.out.println();
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

