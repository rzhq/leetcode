class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int p = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums[p-1]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.removeDuplicates(new int[] {1,2,2,2,2,3,3,4,5});
        System.out.println(r);
    }
}

