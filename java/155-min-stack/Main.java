// start    2020-01-10 11:16:01
// finish   2020-01-10 12:08:59

import java.util.*;

class MinStack {

    Stack<Integer> s1, s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        if ( s2.isEmpty() || x <= s2.peek() ) s2.push(x);
    }
    
    public void pop() {
        int x = s1.pop();
        if ( x == s2.peek() ) s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class Main {
    public static void main(String[] args) {
        check(0);
    }
    
    static void check(int x) {
        System.out.printf("\n");
    }
}

