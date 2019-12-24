// start    2019-12-24 16:19:36
// finish   2019-12-24 16:50:04

import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if ( s == null || s.length() < 4 ) return list;
        int n = s.length();
        for ( int a = 1; a <= 3; a++ ) {
        for ( int b = a+1; b <= a+3; b++ ) {
        for ( int c = b+1; c <= b+3; c++ ) {
            if ( n - c <=  3 && n - c > 0) {
                int A = Integer.valueOf(s.substring(0, a));
                int B = Integer.valueOf(s.substring(a, b));
                int C = Integer.valueOf(s.substring(b, c));
                int D = Integer.valueOf(s.substring(c, n));
                if ( A > 255 || B > 255 || C > 255 || D > 255 ) continue;
                String res = A + "." + B + "." + C + "." + D;
                if ( res.length() == n + 3 ) list.add(res);
            }
        }}}
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        check("123");
        check("1234");
        check("1234567");
        check("010010");
    }
    
    static void check(String input) {
        Solution s = new Solution();
        List<String> ret = s.restoreIpAddresses(input);
        System.out.printf("%s\n", ret);
    }
}

