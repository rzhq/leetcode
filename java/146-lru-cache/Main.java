import java.util.*;

class LRUCache {

    class Node {
        int key,val;
        Node prev;
        Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    int cap;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node n) {
        n.prev = tail.prev;
        n.next = tail;
        tail.prev.next = n;
        tail.prev = n;
        map.put(n.key, n);
    }

    void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        map.remove(n.key);
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            addNode(n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) removeNode(map.get(key));
        else if (map.size() >= cap) removeNode(head.next);
        Node n = new Node(key, value);
        addNode(n);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class Main {
    public static void main(String[] args) {
        int cap, k, v;
        cap = 10; k = 1; v = 1;
        check(cap, k, v);
    }
    
    static void check(int cap, int k, int v) {
        LRUCache s = new LRUCache(cap);
        s.put(k, v);
        int res = s.get(k);
        System.out.printf("%d\n", res);
    }
}

