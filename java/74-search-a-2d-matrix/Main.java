// start  2019-12-17 16:36:50
// finish 2019-12-17 17:07:38

import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix.length < 1 || matrix[0].length < 1 ) return false;
        int p = matrix.length, q = matrix[0].length;
        int l = 0, r = p * q - 1, m;
        while ( l <= r ) {
            m = ( l + r ) / 2;
            if ( matrix[m/q][m%q] < target ) l = m + 1;
            else if ( matrix[m/q][m%q] > target ) r = m - 1;
            else return true;
        }
        return false;
    }

    public boolean searchMatrixCrap(int[][] matrix, int target) {
        if ( matrix.length < 1 || matrix[0].length < 1 ) return false;
        int m = matrix.length, n = matrix[0].length;
        int ll = 0, rr = m - 1, mm;
        while ( ll <= rr ) {
            mm = ( ll + rr ) / 2;
            if ( target < matrix[mm][0] ) rr = mm - 1;
            else if ( target > matrix[mm][n-1] ) ll = mm + 1;
            else {
                int l = 0, r = n - 1, mi;
                int[] arr = matrix[mm];
                while ( l <= r ) {
                    mi = ( l + r ) / 2;
                    if ( arr[mi] > target ) r = mi - 1;
                    else if ( arr[mi] < target ) l = mi + 1;
                    else return true;
                }
                return false;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] input;
        input = new int[][] {{1,2,3},{5,6,7},{10,11,12}};
        check(input, 3, true);
        input = new int[][] {{1,2,3},{5,6,7},{10,11,12}};
        check(input, 4, false);
    }
    
    static void check(int[][] input, int target, boolean out) {
        Solution s = new Solution();
        boolean ret = s.searchMatrix(input, target);
        System.out.printf("%s %s\n", ret, out);
    }
}

