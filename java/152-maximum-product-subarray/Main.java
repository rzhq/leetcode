// start    2019-12-22 13:41:07
// finish   2019-12-22 14:14:12

import java.util.*;

class Solution {
    public int maxProduct(int[] A) {
        int max = A[0], min = A[0], tmp;
        int m = A[0];
        for ( int i = 1; i < A.length; i++ ) {
            if ( A[i] < 0 ) {
                tmp = max; max = min; min = tmp;
            }
            max = Math.max(max * A[i], A[i]);
            min = Math.min(min * A[i], A[i]);
            m = Math.max(m, max);
        }
        return m;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {2,3,-2,4};
        check(input, 6);
        input = new int[] {2,3,0,2,4,-2,4};
        check(input, 8);
        input = new int[] {2,3,0,-1,2,4,-2,0,4};
        check(input, 16);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.maxProduct(input);
        System.out.printf("%d %d\n", ret, out);
    }
}

