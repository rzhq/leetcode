// start  2019-12-16 09:28:47
// finish 2019-12-16 09:44:10

import java.util.*;

class Solution {
    public int trailingZeroes(int n) {
        int ret = 0;
        while ( n > 0 ) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        check(3);
        check(5);
        check(10);
        check(12);
        check(15);
        check(20);
        check(30);
    }
    
    static void check(int x) {
        Solution s = new Solution();
        int ret = s.trailingZeroes(x);
        long fac = 1;
        while ( x > 0 ) fac *= x--;
        int i = 0;
        long res = fac;
        while ( fac % 10 == 0 ) { i++; fac /= 10; }
        System.out.printf("%d %d fac:%d\n", ret, i, res);
    }
}

