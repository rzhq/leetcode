// start    2019-12-23 10:14:36
// finish   2019-12-23 11:26:13

import java.util.*;

class Solution {
    public int findDuplicate(int[] A) {
        return solveN(A);
    }

    int solveNlogN(int[] A) {
        if ( A.length < 2 ) return -1;
        int l = 1, h = A.length - 1, m;
        while ( l < h ) {
            m = ( l + h ) / 2;
            int c = 0;
            for ( int n : A) {
                if ( n <= m ) c++;
            }
            if ( c <= m ) l = m + 1;
            else h = m;
        }
        return l;
    }
    
    int solveN(int[] A) {
        if ( A.length < 2 ) return -1;
        int slow = A[0], fast = A[A[0]];
        while ( slow != fast ) {
            slow = A[slow];
            fast = A[A[fast]];
        }
        fast = 0;
        while ( slow != fast ) {
            slow = A[slow];
            fast = A[fast];
        }
        return slow;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3,4,2};
        check(input, 2);
        input = new int[] {1,2,3,4,1};
        check(input, 1);
        input = new int[] {1,2,3,1,1};
        check(input, 1);
        input = new int[] {1,1};
        check(input, 1);
        input = new int[] {2,2,2,2,2,2,2};
        check(input, 2);
        input = new int[] {3,1,3,4,2};
        check(input, 3);
        input = new int[] {};
        check(input, -1);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.findDuplicate(input);
        System.out.printf("%d %d\n", ret, out);
    }
}

