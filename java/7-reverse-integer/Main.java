// start  2019-12-15 14:17:42
// finish 2019-12-15 15:17:50

import java.util.*;

class Solution {
    public int reverse(int x) {
        int res = 0, check;
        while ( x != 0 ) {
            check = res;
            res = res * 10 + ( x % 10 );
            if ( res / 10 != check ) return 0;
            x /= 10;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        check(0);
        check(1);
        check(12);
        check(123);
        check(-123);
        check(120);
        check(-120);
        check(1200);
        check(-7654567);
        check(-76544567);
        check(((1<<31)-1) / 100 * 100 + 99);
    }
    
    static void check(int x) {
        Solution s = new Solution();
        int ret = s.reverse(x);
        System.out.printf("%d\n%d\n\n", x, ret);
    }
}

