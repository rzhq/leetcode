// start    2020-01-08 21:47:38
// finish   2020-01-08 22:05:53

import java.util.*;

class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while ( --n != 0 ) {
            b += a;
            a = b - a;
        }
        return b;
    }
}

public class Main {
    public static void main(String[] args) {
        check(2, 2);
        check(3, 3);
        check(4, 5);
    }
    
    static void check(int x, int out) {
        Solution s = new Solution();
        int ret = s.climbStairs(x);
        System.out.printf("%d %d\n", ret, out);
    }
}

