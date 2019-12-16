// start  2019-12-16 09:47:22
// finish 2019-12-16 10:38:07

import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        if ( n < 0 ) n = -n;
        int slow = n, fast = n;
        do {
            slow = step(slow);
            fast = step(step(fast));
        } while ( fast != slow );
        if ( fast == 1 ) return true;
        return false;
    }

    int step(int n) {
        int r = 0;
        while ( n > 0 ) {
            r += ( n % 10 ) * ( n % 10 );
            n /= 10;
        }
        return r;
    }
}

public class Main {
    public static void main(String[] args) {
        check(19, true);
        check(20, false);
        check(29, false);
    }
    
    static void check(int x, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isHappy(x);
        System.out.printf("%s %s\n", ret, out);
    }
}

