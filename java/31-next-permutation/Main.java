// start  19-12-09 11:10
// finish 19-12-09 11:49
import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        if ( nums.length < 2 ) { return; }
        int temp = 0;
        int p = nums.length - 1;
        int q = p;
        while ( p > 0 && nums[p-1] >= nums[p] ) { p--; }
        if (p > 0) {
            while (nums[p-1] >= nums[q]) { q--; }
            temp = nums[p-1];
            nums[p-1] = nums[q];
            nums[q] = temp;
        }
        q = nums.length - 1;
        while ( p < q ) {
            temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            p++;
            q--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[] {1,5,1};
        s.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }
}

