// start  19-12-09 17:58
// finish 19-12-09 18:17
class Solution {
    public int searchInsert(int[] nums, int target) {
        if ( nums.length < 1 || nums[0] >= target ) { return 0; }
        for ( int i=1; i < nums.length; i++ ) {
            if ( nums[i] >= target ) {
                return i;
            }
        }
        return nums.length;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.searchInsert(new int[] {1}, 2);
        System.out.println(r);
    }
}

