// start  2019-12-15 19:30:20
// finish 2019-12-15 20:34:11

import java.util.*;

class Solution {
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        if ( n < 0 ) return ret.toString();
        toString(ret, n);
        return ret.toString();
    }

    void toString(StringBuilder sb, int n) {
        if ( n > 0 ) {
            n--;
            toString(sb, n / 26);
            sb.append((char) ('A' + n % 26) );
        }
    }
}

public class Main {
    public static void main(String[] args) {
        check(1, "A");
        check(26, "Z");
        check(27, "AA");
        check(701, "ZY");
    }
    
    static void check(int x, String out) {
        Solution s = new Solution();
        String ret = s.convertToTitle(x);
        System.out.printf("%s %s\n", ret, out);
    }
}

