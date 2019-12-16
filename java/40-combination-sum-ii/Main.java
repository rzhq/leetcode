// start  2019-12-16 14:49:21
// finish 2019-12-16 15:18:41

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if ( candidates == null || candidates.length < 1 ) return list;
        Arrays.sort(candidates);
        find(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    void find(int[] nums, int i, int target, List<Integer> l, List<List<Integer>> list) {
        if ( target < 0 ) return;
        if ( target == 0 ) list.add(new ArrayList<>(l));
        for ( int j = i; j < nums.length; j++ ) {
            if ( j > i && nums[j] == nums[j-1] ) continue;
            l.add(nums[j]);
            find(nums, j+1, target-nums[j], l, list);
            l.remove(l.size()-1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {};
        check(input, 1);
        input = new int[] {1};
        check(input, 1);
        input = new int[] {1};
        check(input, 2);
        input = new int[] {10,1,2,7,6,1,5};
        check(input, 8);
    }
    
    static void check(int[] input, int tgt) {
        Solution s = new Solution();
        List<List<Integer>> list = s.combinationSum2(input, tgt);
        System.out.println(list);
    }
}

