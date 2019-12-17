// start  2019-12-17 20:56:23
// finish 2019-12-17 21:17:27

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if ( nums == null || nums.length < 1 ) return list;
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), list);
        return list;
    }

    void dfs(int[] nums, int i, List<Integer> l, List<List<Integer>> list) {
        list.add(new ArrayList<>(l));
        for ( int j = i; j < nums.length; j++ ) {
            if ( j > 0 && nums[j] == nums[j-1] ) continue;
            l.add(nums[j]);
            dfs(nums, j+1, l, list);
            l.remove(l.size()-1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3};
        check(input);
        input = new int[] {1,2,2,3,4,5};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.subsets(input);
        System.out.println(ret);
    }
}

