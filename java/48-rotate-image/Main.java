// start  2019-12-16 15:22:03
// finish 2019-12-16 16:12:50

import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        int tmp;
        for ( int i = 0; i < matrix.length / 2; i++ ) {
            for ( int j = 0; j < matrix.length; j++ ) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = tmp;
            }
        }
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = i + 1; j < matrix.length; j++ ) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] input;
        input = new int[][] {
          {1,2,3},
          {4,5,6},
          {7,8,9}
        };
        check(input);
    }
    
    static void check(int[][] input) {
        Solution s = new Solution();
        s.rotate(input);
        System.out.println(Arrays.deepToString(input));
    }
}

