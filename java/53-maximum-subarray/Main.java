// start  19-12-10 11:27
// finish 19-12-10 12:40

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for ( int i = 1; i < nums.length; i++ ) {
            nums[i] += nums[i-1] > 0 ? nums[i-1] : 0;
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int maxSubArrayN(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for ( int i = 1; i < nums.length; i++ ) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArrayDumb(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int maxSum = nums[0];
        for ( int n : nums ) {
            if ( max < n ) { max = n; }
            sum += n;
            if ( sum >= 0 ) {
                if ( sum > maxSum ) { maxSum = sum; }
            } else {
                sum = 0;
            }
        }
        if ( max <= 0 ) { return max; }
        return maxSum > max ? maxSum : max;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int r = s.maxSubArray(input);
        System.out.println(r);
    }
}

