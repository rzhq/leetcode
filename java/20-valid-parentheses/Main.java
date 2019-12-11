// start  2019-12-11 19:15:31
// finish 2019-12-11 20:04:34

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int p = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            switch ( s.charAt(i) ) {
                case '(':
                case '[':
                case '{':
                    stack[p] = s.charAt(i);
                    p++;
                    continue;
            }
            if ( p < 1 ) return false;
            switch ( s.charAt(i) ) {
                case ')':
                    if ( stack[--p] != '(' ) return false;
                    break;
                case ']':
                    if ( stack[--p] != '[' ) return false;
                    break;
                case '}':
                    if ( stack[--p] != '{' ) return false;
                    break;
            }
        }
        return p == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        String input;
        input = "()()[]{}";
        check(input);
        input = "{[()()(())][()][[()]]}";
        check(input);
        input = "{{[()()(())][()][[()]]}}{}";
        check(input);
        input = "{([])}";
        check(input);

        input = "{[}]";
        check(input);
        input = "[(])";
        check(input);
        input = ")";
        check(input);
        input = "]";
        check(input);
        input = "}";
        check(input);
    }
    
    static void check(String input) {
        Solution s = new Solution();
        boolean ret = s.isValid(input);
        System.out.println(ret);
    }
}

