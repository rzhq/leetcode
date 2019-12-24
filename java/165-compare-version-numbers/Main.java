// start    2019-12-24 22:06:48
// finish   2019-12-24 22:32:18

import java.util.*;

class Solution {
    public int compareVersion(String v1, String v2) {
        if ( v1 == null || v2 == null ) return -2;
        int m = v1.length(), n = v2.length();
        if ( n == 0 ) return 1;
        if ( m == 0 ) return -1;
        int i = 0, j = 0, p1, p2;
        while ( i < m || j < n ) {
            p1 = 0; p2 = 0;
            while ( i < m && v1.charAt(i) != '.' ) p1 = p1 * 10 + ( v1.charAt(i++) - '0' );
            while ( j < n && v2.charAt(j) != '.' ) p2 = p2 * 10 + ( v2.charAt(j++) - '0' );
            if ( p1 > p2 ) return 1;
            else if ( p1 < p2 ) return -1;
            i++; j++;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        check("0.1", "1.1", -1);
        check("1.0.1", "1", 1);
        check("7.5.2.4", "7.5.3", -1);
        check("1.01", "1.001", 0);
        check("1.0.0", "1.0", 0);
        check("1.1", "1.10", -1);
    }
    
    static void check(String v1, String v2, int out) {
        Solution s = new Solution();
        int ret = s.compareVersion(v1, v2);
        System.out.printf("%d %d\n", ret, out);
    }
}

