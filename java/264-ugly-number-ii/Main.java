// start    2020-01-08 17:05:26
// finish   2020-01-08 17:24:31

import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        if ( n <= 1 ) return 1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        for ( int i = 1; i < n; i++ ) {
            int u = Math.min(Math.min(n2, n3), n5);
            ugly[i] = u;
            if ( u == n2 ) n2 = ugly[++i2] * 2;
            if ( u == n3 ) n3 = ugly[++i3] * 3;
            if ( u == n5 ) n5 = ugly[++i5] * 5;
        }
        return ugly[n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        check(10, 12);
        check(11, 15);
    }
    
    static void check(int x, int out) {
        Solution s = new Solution();
        int ret = s.nthUglyNumber(x);
        System.out.printf("%d %d\n", ret, out);
    }
}

