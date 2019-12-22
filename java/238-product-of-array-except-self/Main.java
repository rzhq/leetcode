// start    2019-12-22 20:25:43
// finish   2019-12-22 20:42:34

import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] A) {
        if ( A.length < 1 ) return new int[] {};
        int[] res = new int[A.length];
        res[0] = 1;
        for ( int i = 1; i < A.length; i++ ) {
            res[i] = res[i-1] * A[i-1];
        }
        int tmp = 1;
        for ( int i = A.length - 2; i >= 0; i-- ) {
            tmp *= A[i+1];
            res[i] *= tmp;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3,4};
        check(input, "[24,12,8,6]");
        input = new int[] {4};
        check(input, "[1]");
        input = new int[] {2,3};
        check(input, "[3,2]");
    }
    
    static void check(int[] input, String out) {
        Solution s = new Solution();
        int[] ret = s.productExceptSelf(input);
        System.out.printf("%s\n%s\n", Arrays.toString(ret), out);
    }
}

