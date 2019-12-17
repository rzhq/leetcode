// start  2019-12-17 11:03:11
// finish 2019-12-17 11:27:27

import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        if ( n < 1 ) return new int[0][0];
        int t = 0, b = n - 1, l = 0, r = n - 1;
        int c = 1;
        int[][] m = new int[n][n];
        while ( t <= b && l <= r ) {
            for ( int i = l; i <= r; i++ ) m[t][i] = c++;
            t++;
            for ( int i = t; i <= b; i++ ) m[i][r] = c++;
            r--;
            for ( int i = r; i >= l; i-- ) m[b][i] = c++;
            b--;
            for ( int i = b; i >= t; i-- ) m[i][l] = c++;
            l++;
        }
        return m;
    }

    public int[][] generateMatrix2(int n) {
        if ( n < 1 ) return new int[0][0];
        int c = 1;
        int[][] m = new int[n][n];
        int di = 1, dj = 1;
        int i = 0, j = -1;
        int p = n-1, q = n;
        while ( p >= 0 && q >= 0 ) {
            for ( int jj = 0 ; jj < q; jj++ ) {
                j += dj;
                m[i][j] = c++;
            }
            dj = -dj;
            q--;
            for ( int ii = 0 ; ii < p; ii++ ) {
                i += di;
                m[i][j] = c++;
            }
            di = - di;
            p--;
        }
        return m;
    }
}

public class Main {
    public static void main(String[] args) {
        check(0);
        check(1);
        check(2);
        check(3);
        check(4);
        check(5);
    }
    
    static void check(int input) {
        Solution s = new Solution();
        int[][] ret = s.generateMatrix(input);
        System.out.println(Arrays.deepToString(ret));
    }
}

