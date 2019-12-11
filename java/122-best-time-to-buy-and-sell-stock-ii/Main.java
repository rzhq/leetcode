// start  19-12-11 11:52
// finish 19-12-11 12:28
import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        if ( prices.length < 1 ) { return 0; }
        int sum = 0;
        int min = prices[0];
        for ( int i = 1; i < prices.length; i++ ) {
            if ( prices[i] < prices[i-1] ) {
                sum += prices[i-1] - min;
                min = prices[i];
            } else if ( prices[i] < min ) {
                min = prices[i];
            }
        } 
        if ( prices[prices.length-1] > min ) {
            sum += prices[prices.length-1] - min;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {7,1,5,3,6,4};
        check(input, 7);
        input = new int[] {7,6,4};
        check(input, 0);
        input = new int[] {7,6,4,5,6,1,2,3};
        check(input, 4);
        input = new int[] {4};
        check(input, 0);
        input = new int[] {};
        check(input, 0);
        input = new int[] {1,2};
        check(input, 1);
        input = new int[] {2,1};
        check(input, 0);
    }
    
    static void check(int[] input, int output) {
        Solution s = new Solution();
        int ret = s.maxProfit(input);
        System.out.printf("%d %d\n", ret, output);
    }
}

