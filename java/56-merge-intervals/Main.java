// start  2019-12-16 19:09:21
// finish 2019-12-16 20:35:57

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if ( intervals.length < 2 ) return intervals;
        Arrays.sort(intervals, ( i1, i2 ) -> Integer.compare(i1[0], i2[0]));
        int i = 0, j = 1;
        while ( j < intervals.length ) {
            if ( intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                if ( i + 1 < j ) {
                    intervals[i+1][0] = intervals[j][0];
                    intervals[i+1][1] = intervals[j][1];
                }
                i++;
            }
            j++;
        }
        int[][] ret = new int[i+1][2];
        for ( int k = 0; k <= i; k++ ) {
            ret[k][0] = intervals[k][0];
            ret[k][1] = intervals[k][1];
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] input;
        input = new int[][] {{1,2},{3,4}};
        check(input);
        input = new int[][] {{1,2}};
        check(input);
        input = new int[][] {{1,2},{2,4},{6,8},{5,9},{11,12}};
        check(input);
        input = new int[][] {{1,3},{2,4},{8,10}};
        check(input);
        input = new int[][] {{1,3},{2,4},{0,10}};
        check(input);
        input = new int[][] {{1,3},{2,4},{0,0},{5,7}};
        check(input);
        input = new int[][] {{1,3},{2,4},{0,0},{1,4}};
        check(input);
        input = new int[][] {{1,1},{1,1},{0,0}};
        check(input);
    }
    
    static void check(int[][] input) {
        Solution s = new Solution();
        int[][] ret = s.merge(input);
        System.out.println(Arrays.deepToString(ret));
    }
}

