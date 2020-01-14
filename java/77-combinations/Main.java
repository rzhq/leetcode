// start    2020-01-14 17:24:07
// finish   2020-01-14 17:52:18

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if ( n < 1 || k < 1 ) return list;
        dfs(1, n, k, new ArrayList<>(), list);
        return list;
    }

    void dfs(int i, int n, int k, List<Integer> l, List<List<Integer>> list) {
        if ( k == 0 ) {
            list.add(new ArrayList<>(l));
            return;
        }
        for ( int j = i; j <= n; ++j ) {
            l.add(j);
            dfs(j+1, n, k-1, l, list);
            l.remove(l.size()-1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        check(4, 2);
    }
    
    static void check(int n, int k) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.combine(n, k);
        System.out.printf("%s\n", ret);
    }
}

