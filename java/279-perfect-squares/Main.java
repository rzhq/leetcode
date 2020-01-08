// start    2020-01-08 21:14:52
// finish   2020-01-08 21:42:12

import java.util.*;

class Solution {
    public int numSquares(int n) {
        int[] list = new int[n+1];
        list[0] = 0;
        for ( int i = 1; i <= n; i++ ) {
            list[i] = list[i-1] + 1;
            for ( int j = 1; j * j <= i; j++ ) {
                list[i] = Math.min(list[i], list[i-j*j] + 1);
            }
        }
        return list[n];
    }
}

public class Main {
    public static void main(String[] args) {
        check(12, 3);
        check(13, 2);
    }
    
    static void check(int x, int out) {
        Solution s = new Solution();
        int ret = s.numSquares(x);
        System.out.printf("%d %d\n", ret, out);
    }
}

