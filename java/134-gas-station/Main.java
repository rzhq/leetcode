// start    2020-01-19 09:44:32
// finish   2020-01-19 09:49:09

import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0, index = 0, tank = 0;
        for ( int i=0; i<gas.length; i++ ) {
            diff += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if ( tank < 0 ) {
                tank = 0;
                index = i + 1;
            }
        }
        if ( diff < 0 ) return -1;
        return index;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] gas, cost;
        gas = new int[] {1,2,3,4,5};
        cost = new int[] {3,4,5,1,2};
        check(gas, cost, 3);
    }
    
    static void check(int[] gas, int[] cost, int out) {
        Solution s = new Solution();
        int ret = s.canCompleteCircuit(gas, cost);
        System.out.printf("%d %d\n", ret, out);
    }
}

