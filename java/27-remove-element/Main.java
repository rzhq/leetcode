class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) { return 0; }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        int i = 0, j = nums.length - 1;
        while (j >= 0 && nums[j] == val) j--;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                nums[j] = val;
                while (j >= 0 && nums[j] == val) j--;
            }
            i++;
        }
        return j+1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.removeElement(new int[] {3,3,4}, 3);
        System.out.println(r);
    }
}

