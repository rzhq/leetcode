// start  19-12-11 11:29
// finish 19-12-11 11:50
import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        if ( prices.length < 1 ) { return 0; }
        int min = prices[0];
        int diff = 0;
        for ( int p : prices ) {
            if ( p < min ) {
                min = p;
                continue;
            }
            if ( p - min > diff ) { diff = p - min; }
        }
        return diff;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input;
        int ret;
        input = new int[] {7,1,5,3,6,4};
        ret = s.maxProfit(input);
        System.out.println(ret);
        input = new int[] {7,6,4};
        ret = s.maxProfit(input);
        System.out.println(ret);
        input = new int[] {4};
        ret = s.maxProfit(input);
        System.out.println(ret);
        input = new int[] {};
        ret = s.maxProfit(input);
        System.out.println(ret);
        input = new int[] {1,2};
        ret = s.maxProfit(input);
        System.out.println(ret);
        input = new int[] {2,1};
        ret = s.maxProfit(input);
        System.out.println(ret);
    }
}

