import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {3,2,1,5,6,4};
        check(input, 2, 5);
        input = new int[] {3,2,3,1,2,4,5,5,6};
        check(input, 4, 4);
    }

    static void check(int[] input, int k, int exp) {
        Solution s = new Solution();
        int res = s.findKthLargest(input, k);
        System.out.printf("%d %d\n", exp, res);
    }
}

