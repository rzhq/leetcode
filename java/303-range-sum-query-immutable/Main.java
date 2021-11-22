import java.util.*;

class NumArray {

    int[] arr;

    public NumArray(int[] nums) {
        arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            arr[i] = nums[i] + arr[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) return arr[right];
        return arr[right] - arr[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

public class Main {
    public static void main(String[] main) {
        int[] nums = {1, 2, 3, 4, 5};
        NumArray a = new NumArray(nums);
        System.out.printf("%d\n", a.sumRange(1, 3));
        System.out.printf("%d\n", a.sumRange(2, 4));
    }

}
