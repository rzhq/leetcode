// start  2019-12-15 16:18:39
// finish 2019-12-15 17:06:58

import java.util.*;

class Solution {
    public int mySqrt(int x) {
        if ( x < 0 ) return -1;
        if ( x <= 1 ) return x;
        int i = 0, j = x, m;
        while ( i <= j ) {
            m = ( i + j ) / 2;
            if ( x / m == m ) return m;
            else if ( x / m < m ) j = m - 1;
            else i = m + 1;
        }
        return j;
    }
}

public class Main {
    public static void main(String[] args) {
        check(0);
        check(1);
        check(2);
        check(3);
        check(4);
        check(5);
        check(6);
        check(7);
        check(8);
        check(9);
        check(10);
        check(11);
        check(12);
        check(120);
        check(121);
        check((1<<31)-1);
    }
    
    static void check(int x) {
        Solution s = new Solution();
        int ret = s.mySqrt(x);
        System.out.printf("%d %d\n", (int) Math.sqrt(x), ret);
    }
}

