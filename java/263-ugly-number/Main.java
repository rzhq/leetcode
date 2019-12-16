// start  2019-12-16 11:37:36
// finish 2019-12-16 11:52:09

import java.util.*;

class Solution {
    public boolean isUgly(int num) {
        if ( num < 1 ) return false;
        for ( int i = 5; i > 1; i-- ) {
            while ( num % i == 0 ) num /= i;
        }
        return num == 1;
    }
}

public class Main {
    public static void main(String[] args) {
        check(0, false);
        check(1, true);
        check(6, true);
        check(8, true);
        check(14, false);
    }
    
    static void check(int x, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isUgly(x);
        System.out.printf("%s %s\n", ret, out);
    }
}

