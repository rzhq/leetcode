// start    2020-01-18 20:34:23
// finish   2020-01-18 21:07:30

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if ( node == null ) return null;
        Map<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    Node clone(Node node, Map<Integer, Node> map) {
        if ( map.containsKey(node.val) ) return map.get(node.val);
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        for ( Node n : node.neighbors ) {
            clonedNode.neighbors.add(clone(n, map));
        }
        return clonedNode;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        check(node);
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        System.out.println();
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

