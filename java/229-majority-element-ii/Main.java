// start    2019-12-22 18:44:23
// finish   2019-12-22 19:40:22

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] A) {
        List<Integer> list = new ArrayList<>();
        if ( A.length < 1 ) return list;
        int p = A[0], q = A[0], cp = 0, cq = 0;
        for ( int i = 0; i < A.length; i++ ) {
            if ( p == A[i] ) {
                cp++;
            } else if ( q == A[i] ) {
                cq++;
            } else if ( cp == 0 ) {
                p = A[i];
                cp = 1;
            } else if ( cq == 0 ) {
                q = A[i];
                cq = 1;
            } else {
                cp--; cq--;
            }
        }
        cp = cq = 0;
        for ( int n : A ) {
            if ( n == p ) cp++;
            else if ( n == q ) cq++;
        }
        if ( cp > A.length / 3 ) list.add(p);
        if ( cq > A.length / 3 ) list.add(q);
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,1,1,1,1,2,2,3,3,4,4,5};
        check(input, "1");
        input = new int[] {1,1,1,1,1,2,3,3,3,3,3,5};
        check(input, "1 3");
        input = new int[] {1,1};
        check(input, "1");
        input = new int[] {1};
        check(input, "1");
        input = new int[] {1,2};
        check(input, "1 2");
        input = new int[] {1,2,2};
        check(input, "2");
        input = new int[] {1,2,3};
        check(input, "null");
        input = new int[] {};
        check(input, "null");
    }
    
    static void check(int[] input, String out) {
        Solution s = new Solution();
        List<Integer> ret = s.majorityElement(input);
        System.out.println(ret);
        System.out.printf("%s\n", out);
    }
}

