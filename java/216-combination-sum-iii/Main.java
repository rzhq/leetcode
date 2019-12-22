// start    2019-12-22 17:32:06
// finish   2019-12-22 18:05:27

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        if ( k < 1 || n < 1 ) return list;
        dfs(1, k, n, new ArrayList<>(), list);
        return list;
    }

    void dfs(int i, int k, int n, List<Integer> l, List<List<Integer>> list) {
        if ( n < 0 ) return;
        if ( l.size() == k ) {
            if ( n == 0 ) list.add(new ArrayList<>(l));
            else return;
        }
        for ( int j = i; j <= Math.min(9, n); j++ ) {
            l.add(j);
            dfs(j+1, k, n-j, l, list);
            l.remove(l.size() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        check(0, 1);
        check(1, 0);
        check(1, 1);
        check(3, 7);
        check(3, 9);
    }
    
    static void check(int k, int n) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.combinationSum3(k, n);
        System.out.println(ret);
    }
}

