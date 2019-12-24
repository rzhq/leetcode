// start    2019-12-24 14:30:22
// finish   2019-12-24 15:03:51

import java.util.*;

class Solution {
    public int numDecodings(String s) {
        if ( s.length() < 1 ) return 0;
        if ( s.charAt(0) == '0' ) return 0;
        int n = s.length();
        int[] A = new int[n];
        A[0] = s.charAt(0) == '0' ? 0 : 1;
        for ( int i = 1; i < n; i++ ) {
            int first = s.charAt(i) - '0';
            int second = ( s.charAt(i-1) - '0' ) * 10 + first;
            if ( first >= 1 && first <= 9 ) A[i] += A[i-1];
            if ( second >= 10 && second <= 26 ) A[i] += i > 2 ? A[i-2] : 1;
        }
        return A[n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        check("0", 0);
        check("1", 1);
        check("12", 2);
        check("012", 0);
        check("226", 3);
        check("236", 2);
    }
    
    static void check(String input, int out) {
        Solution s = new Solution();
        int ret = s.numDecodings(input);
        System.out.printf("%d %d\n", ret, out);
    }
}

