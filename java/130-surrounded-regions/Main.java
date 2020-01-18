// start    2020-01-18 16:55:52
// finish   2020-01-18 17:18:28

import java.util.*;

class Solution {
    public void solve(char[][] b) {
        int m = b.length;
        if ( m < 1 ) return;
        int n = b[0].length;
        if ( n < 1 ) return;
        
        for ( int i=0; i<m; i++ ) {
            check(b, i, 0, m, n);
            if ( n > 1 ) check(b, i, n-1, m, n);
        }
        for ( int i=0; i<n; i++ ) {
            check(b, 0, i, m, n);
            if ( m > 1 ) check(b, m-1, i, m, n);
        }
        
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( b[i][j] == 'O' ) b[i][j] = 'X';
                if ( b[i][j] == '1' ) b[i][j] = 'O';
            }
        }
    }

    void check(char[][] b, int i, int j, int m, int n) {
        if ( b[i][j] == 'O' ) {
            b[i][j] = '1';
            if ( i > 0 ) check(b, i-1, j, m, n);
            if ( j > 0 ) check(b, i, j-1, m, n);
            if ( i < m-1 ) check(b, i+1, j, m, n);
            if ( j < n-1 ) check(b, i, j+1, m, n);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        check("");
    }
    
    static void check(String input) {
        Solution s = new Solution();
        System.out.printf("\n");
    }
}

