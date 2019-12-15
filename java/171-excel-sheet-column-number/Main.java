// start  2019-12-15 20:56:28
// finish 2019-12-15 21:04:22

import java.util.*;

class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            num = num * 26 + (int) ( s.charAt(i) - 'A' + 1 );
        }
        return num;
    }
}

public class Main {
    public static void main(String[] args) {
        check("A", 1);
        check("AB", 28);
        check("ZY", 701);
    }
    
    static void check(String x, int out) {
        Solution s = new Solution();
        int ret = s.titleToNumber(x);
        System.out.printf("%d %d\n", ret, out);
    }
}

