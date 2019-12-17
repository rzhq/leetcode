// start  2019-12-17 20:26:47
// finish 2019-12-17 20:55:26

import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        if ( nums.length < 2 ) return;
        int i = 0, k = nums.length - 1;
        for ( int j = 0; j <= k; ) {
            if ( nums[j] == 0 ) {
                nums[j] = nums[i];
                nums[i] = 0;
                i++; j++;
            } else if ( nums[j] == 2 ) {
                nums[j] = nums[k];
                nums[k] = 2;
                k--;
            } else {
                j++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {2,0,2,1,1,0};
        check(input);
        input = new int[] {2};
        check(input);
        input = new int[] {2,1};
        check(input);
        input = new int[] {1,0,2,0,0,0,1,1,0,2};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        s.sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}

