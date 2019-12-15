// start  2019-12-15 15:18:44
// finish 2019-12-15 15:33:00

import java.util.*;

lass Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) return false;
        int i = 1, j = 1;
        while ( x / i > 9 ) i *= 10;
        while ( i > j ) {
            if ( (x / i) % 10 != (x / j) % 10 ) return false;
            i /= 10;
            j *= 10;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        check(-1, false);
        check(123, false);
        check(121, true);
        check(1211, false);
        check(1221, true);
        check(1, true);
        check(0, true);
        check(12021, true);
        check(120021, true);
    }
    
    static void check(int x, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isPalindrome(x);
        System.out.printf("%s %s\n", out, ret);
    }
}

