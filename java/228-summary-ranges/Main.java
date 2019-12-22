// start    2019-12-22 18:13:59
// finish   2019-12-22 18:35:19

import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] A) {
        int i = 0, j = 0;
        List<String> list = new ArrayList<>();
        while ( j < A.length ) {
            while ( j < A.length - 1 && A[j+1] == A[j] + 1 ) j++;
            if ( i == j ) list.add(String.valueOf(A[i]));
            else list.add(String.format("%d->%d", A[i], A[j]));
            i = ++j;
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,4,5,6,8};
        check(input);
        input = new int[] {1,4,5,6,8,9};
        check(input);
        input = new int[] {1};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        List<String> ret = s.summaryRanges(input);
        System.out.println(Arrays.toString(input));
        System.out.println(ret);
    }
}

