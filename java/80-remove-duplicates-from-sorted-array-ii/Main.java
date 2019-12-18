// start  2019-12-18 13:58:47
// finish 2019-12-18 14:27:15

import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        if ( nums.length < 3 ) return nums.length;
        int i = 2;
        for ( int j = 2; j < nums.length; j++ ) {
            if ( nums[j] > nums[i-2] ) nums[i++] = nums[j];
        }
        return i;
    }

    public int removeDuplicatesDumb(int[] nums) {
        if ( nums.length < 3 ) return nums.length;
        int i = 0, j = 1, k = 2;
        while ( j < nums.length -1 && k < nums.length ) {
            if ( nums[i] == nums[j] ) {
                while ( nums[j] == nums[k] ) {
                    k++;
                    if ( k >= nums.length ) return j+1;
                }
            }
            nums[j+1] = nums[k];
            i++; j++; k++;
        }
        return j+1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2};
        check(input, 2);
        input = new int[] {1,2,3};
        check(input, 3);
        input = new int[] {1,2,3,4};
        check(input, 4);
        input = new int[] {0,0,0,0,1,2,3,3,3,4,4};
        check(input, 8);
        input = new int[] {0,1,1,2,3,3,4,4};
        check(input, 8);
        input = new int[] {0,1,1,1,2,2,2,3,3,4,4,5};
        check(input, 10);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.removeDuplicates(input);
        System.out.println(Arrays.toString(Arrays.copyOfRange(input, 0, ret)));
        System.out.printf("%d %d\n", ret, out);
    }
}

