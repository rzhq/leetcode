// start  2019-12-17 12:59:19
// finish 2019-12-17 13:32:39

import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ( obstacleGrid.length < 1 ) return 0;
        if ( obstacleGrid[0].length < 1 ) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] d = new int[n];
        d[0] = 1;
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( obstacleGrid[i][j] == 1 ) d[j] = 0;
                else if ( j > 0 ) d[j] += d[j-1];
            }
        }
        return d[n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] input;
        input = new int[][] {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        check(input);
        input = new int[][] {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        check(input);
        input = new int[][] {
            {0,0,0,0},
            {0,1,0,0},
            {0,0,0,0}
        };
        check(input);
        input = new int[][] {
            {1,0,0},
            {0,0,0},
            {0,0,0}
        };
        check(input);
        input = new int[][] {
            {0,0,0},
            {0,0,1},
            {0,1,0}
        };
        check(input);
        input = new int[][] {
            {0,1,0},
            {1,0,0},
            {0,0,0}
        };
        check(input);
    }
    
    static int find(int i, int j, int[][] m) {
        if ( m.length < 1 ) return 0;
        if ( m[0].length < 1 ) return 0;
        if ( i < m.length && j < m[0].length ) {
            if ( m[i][j] == 1 ) return 0;
            else if ( i == m.length-1 && j == m[0].length-1 ) return 1;
            else return find(i+1, j, m) + find(i, j+1, m);
        } else {
            if ( i >= m.length ) return m[m.length-1][j];
            if ( j >= m[0].length ) return m[i][m[0].length-1];
            return 0;
        }
    }
    
    static void check(int[][] input) {
        Solution s = new Solution();
        int ret = s.uniquePathsWithObstacles(input);
        int out = find(0, 0, input);
        System.out.printf("%d %d\n", ret, out);
    }
}

