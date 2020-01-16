// start    2020-01-16 21:12:33
// finish   2020-01-16 21:20:42

import java.util.*;

class Solution {
    public int numTrees(int n) {
        if ( n < 1 ) return 1;
        int[] G = new int[n+1];
        G[0] = 1;
        for ( int i = 1; i <= n; ++i ) {
            for ( int j = 1; j <= i; ++j ) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}

public class Main {
    public static void main(String[] args) {
        check(0, 1);
        check(1, 1);
        check(2, 2);
        check(3, 5);
    }
    
    static void check(int x, int out) {
        Solution s = new Solution();
        int ret = s.numTrees(x);
        System.out.printf("%d %d\n", ret, out);
    }
}

