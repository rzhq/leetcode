// start  19-12-09 15:09
// finish 19-12-09 16:17

class Solution {
    public int search(int[] nums, int target) {
        if ( nums.length < 1 ) return -1;
        if ( nums.length == 1 ) return nums[0] == target ? 0 : -1;
        int l = 0, r = nums.length - 1, m, s, rm;
        while ( l < r ) {
            m = ( l + r ) / 2;
            if ( nums[m] > nums[r] ) l = m + 1;
            else r = m;
        }
        s = l;
        l = 0; r = nums.length - 1;
        while ( l <= r ) {
            m = ( l + r ) / 2;
            rm = ( m + s ) % nums.length;
            if ( nums[rm] > target ) r = m - 1;
            else if ( nums[rm] < target ) l = m + 1;
            else return rm;
        }
        return -1;
    }

    public int searchDumb(int[] nums, int target) {
        if ( nums.length < 3 ) {
            if ( nums.length > 0 && nums[0] == target ) { return 0; }
            if ( nums.length > 1 && nums[1] == target ) { return 1; }
            return -1;
        }
        int i = 0, j = nums.length - 1;
        if ( target == nums[i] ) { return i; }
        if ( target == nums[j] ) { return j; }
        int k = ( i + j ) / 2;
        while ( i < j - 1 ) {
            System.out.printf("%d %d %d\n", i, k, j);
            if ( target == nums[k] ) {
                return k;
            } else if ( target > nums[i] && target < nums[k] ) {
                j = k;
            } else if ( target > nums[k] && target < nums[j] ) {
                i = k;
            } else if ( nums[k] > nums[i] ){
                i = k;
            } else {
                j = k;
            }
            k = ( i + j ) / 2;
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[] {4,5,6,7,8,1,2,3};
        int r = s.search(input, 8);
        System.out.println(r);
    }
}

