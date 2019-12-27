// start    2019-12-27 18:50:11
// finish   2019-12-27 19:55:14

import java.util.*;

class Solution {
    public int calculate(String s) {
        List<Integer> list = new ArrayList<>();
        int i = 0, n = s.length();
        int a = 0, b = 0, c = 0, si = 1;
        char sign = '+';
        while ( i < n ) {
            while ( i < n && s.charAt(i) == ' ' ) i++;
            while ( i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9' ) {
                c = c * 10 + ( s.charAt(i++) - '0' );
            }
            if ( i == n || ( i < n && s.charAt(i) >= '*' && s.charAt(i) <= '/' ) ) {
                switch ( sign ) {
                    case '+':
                    case '-':
                        a += si * b;
                        b = c; 
                        si = sign == '+' ? 1 : -1;
                        break;
                    case '*':
                        b *= c;
                        break;
                    case '/':
                        b /= c;
                        break;
                }
                sign = i < n ? s.charAt(i++) : sign;
                c = 0;
            }
        }
        a += si * b;
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        check("1+2*3", 7);
        check("   1   + 2 * 3   ", 7);
        check("   1   + 4 *2*2 + 2 * 3   ", 23);
        check("   1   + 3 * 0 *2*2 + 2 * 3 / 5   ", 2);
    }
    
    static void check(String input, int out) {
        Solution s = new Solution();
        System.out.printf("%s\n", input);
        int ret = s.calculate(input);
        System.out.printf("%d %d\n", ret, out);
    }
}

