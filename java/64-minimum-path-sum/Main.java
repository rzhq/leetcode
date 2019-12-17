// start  2019-12-17 13:37:53
// finish 2019-12-17 13:56:50

import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        if ( grid.length < 1 ) return 0;
        if ( grid[0].length < 1 ) return 0;
        int m = grid.length, n = grid[0].length;
        int[] d = new int[n];
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( i == 0 ) {
                    if ( j == 0 ) d[j] = grid[i][j];
                    else d[j] = d[j-1] + grid[i][j];
                } else {
                    if ( j == 0 ) d[j] += grid[i][j];
                    else d[j] = Math.min(d[j-1], d[j]) + grid[i][j];
                }
            }
        }
        return d[n-1];
    }

    public int minPathSumN2Space(int[][] grid) {
        if ( grid.length < 1 ) return 0;
        if ( grid[0].length < 1 ) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] d = new int[m][n];
        for ( int[] arr : d ) {
            Arrays.fill(arr, -1);
        }
        d[0][0] = grid[0][0];
        for ( int i = 1; i < m; i++ ) d[i][0] = d[i-1][0] + grid[i][0];
        for ( int j = 1; j < n; j++ ) d[0][j] = d[0][j-1] + grid[0][j];
        for ( int i = 1; i < m; i++ ) {
            for ( int j = 1; j < n; j++ ) {
                int v = Math.min(d[i-1][j], d[i][j-1]) + grid[i][j];
                if ( d[i][j] == -1 ) d[i][j] = v;
                else d[i][j] = Math.min(d[i][j], v);
            }
        }
        return d[m-1][n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        System.out.printf("\n");
    }
}

