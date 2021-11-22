import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        
        for (String token : tokens) {
            int res = 0;
            if (ops.contains(token)) {
                switch (token) {
                    case "+": res = stack.pop() + stack.pop(); break;
                    case "-": res = -(stack.pop()) + stack.pop(); break;
                    case "*": res = stack.pop() * stack.pop(); break;
                    case "/": res = stack.pop(); res = stack.pop() / res; break;
                }
            } else {
                res = Integer.parseInt(token);
            }
            stack.push(res);
        }
        return stack.pop();
    }
}

public class Main {
    public static void main(String[] args) {
        String[] input;
        input = new String[] {"2","1","+","3","*"};
        check(input, 9);
        input = new String[] {"4","13","5","/","+"};
        check(input, 6);
        input = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        check(input, 22);
    }
    
    static void check(String[] input, int exp) {
        Solution s = new Solution();
        int res = s.evalRPN(input);
        System.out.printf("%d %d\n", exp, res);
    }
}

