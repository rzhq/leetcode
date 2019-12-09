// start  19-12-09 17:05
// finish 19-12-09 17:58
import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int p = -1, q = -1;
        int l = 0, r = nums.length - 1;
        int m = ( l + r ) / 2;
        while ( l <= r ) {
            if ( nums[m] == target ) {
                if ( m+1 >= nums.length || nums[m+1] > target ) {
                    q = m;
                    break;
                } else {
                    l = m + 1;
                }
            } else if ( nums[m] > target ) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = ( l + r ) / 2;
        }
        if ( q == -1 ) { return new int[] {-1, -1}; }
        l = 0;
        r = nums.length - 1;
        m = ( l + r ) / 2;
        while ( l <= r ) {
            if ( nums[m] == target ) {
                if ( m-1 < 0 || nums[m-1] < target ) {
                    p = m;
                    break;
                } else {
                    r = m - 1;
                }
            } else if ( nums[m] > target ) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = ( l + r ) / 2;
        }
        return new int[] {p, q};
        
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[] {8,8,8};
        int r[] = s.searchRange(input, 8);
        System.out.println(Arrays.toString(r));
    }
}

