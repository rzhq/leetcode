// start  2019-12-17 12:02:31
// finish 2019-12-17 12:58:39

import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        if ( m < 2 || n < 2 ) return 1;
        if ( m < n ) { int tmp = n; n = m; m = tmp; }
        int[] d = new int[n];
        Arrays.fill(d, 1);
        for ( int i = 1; i < m; i++ ) {
            for ( int j = 1; j < n; j++ ) {
                d[j] += d[j-1];
            }
        }
        return d[n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        check(1, 1);
        check(1, 2);
        check(2, 1);
        check(2, 2);
        check(3, 3);
        check(4, 4);
        check(4, 5);
        check(3, 2);
        check(7, 3);
    }

    static int find(int i, int j, int m, int n) {
        if ( i == m || j == n ) return 1;
        return find(i+1, j, m, n) + find(i, j+1, m, n);
    }
    
    static void check(int m, int n) {
        Solution s = new Solution();
        int ret = s.uniquePaths(m, n);
        int out;
        if ( m < 2 || n < 2 ) out = 1;
        else out =find(1, 1, m, n);
        System.out.printf("%d %d\n", ret, out);
    }
}

