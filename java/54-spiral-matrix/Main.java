// start  2019-12-16 17:16:14
// finish 2019-12-16 17:57:20

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        if ( n < 1 ) return list;
        int m = matrix[0].length;
        int i = 0, j = -1;
        int ii = 1, jj = 1;
        while ( m > 0 && n > 0 ) {
            for ( int p = 0; p < m; p++ ) {
                j += jj;
                list.add(matrix[i][j]);
            }
            jj = -jj;
            m--;
            for ( int p = 0; p < n - 1; p++ ) {
                i += ii;
                list.add(matrix[i][j]);
            }
            ii = -ii;
            n--;
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] input;
        input = new int[][] {
          {1, 2, 3, 4},
          {5, 6, 7, 8},
          {9,10,11,12}
        };
        check(input);
        input = new int[][] {{}};
        check(input);
        input = new int[][] {{1}};
        check(input);
        input = new int[][] {{1,2}};
        check(input);
        input = new int[][] {{1}, {2}};
        check(input);
        input = new int[][] {{1}, {2}, {3}};
        check(input);
    }
    
    static void check(int[][] input) {
        Solution s = new Solution();
        List<Integer> l = s.spiralOrder(input);
        System.out.println(l);
    }
}

