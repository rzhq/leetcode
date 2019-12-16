// start  2019-12-16 11:10:46
// finish 2019-12-16 11:17:09

import java.util.*;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if ( n == 0 ) return false;
        if ( n == 1 ) return true;
        if ( n % 2 == 1 ) return false;
        return isPowerOfTwo(n / 2);
    }
}

public class Main {
    public static void main(String[] args) {
        check(0, false);
        check(1, true);
        check(2, true);
        check(3, false);
        check(4, true);
        check(8, true);
        check(15, false);
        check(16, true);
    }
    
    static void check(int x, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isPowerOfTwo(x);
        System.out.printf("%s %s\n", ret, out);
    }
}

