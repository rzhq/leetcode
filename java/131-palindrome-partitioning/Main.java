// start    2020-01-18 18:19:19
// finish   2020-01-18 19:20:13

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if ( s.length() < 1 ) return list;
        int n = s.length();

        boolean[][] memo = new boolean[n][n];
        for ( int len=0; len<n; len++ ) {
            for ( int i=0; i<n-len; i++ ) {
                if ( s.charAt(i) == s.charAt(i+len) && ( len<3 || memo[i+1][i+len-1] )) {
                    memo[i][i+len] = true;
                }
            }
        }
        dfs(s, memo, 0, new ArrayList<>(), list);
        return list;
    }

    void dfs(String s, boolean[][] memo, int p, List<String> l, List<List<String>> list) {
        if ( p == s.length() ) {
            list.add(new ArrayList<>(l));
            return;
        }
        for ( int i=p; i<s.length(); i++ ) {
            if ( memo[p][i] ) {
                l.add(s.substring(p, i+1));
                dfs(s, memo, i+1, l, list);
                l.remove(l.size()-1);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        check("aab");
        check("aabbb");
    }
    
    static void check(String input) {
        Solution s = new Solution();
        List<List<String>> ret = s.partition(input);
        System.out.printf("%s\n", ret);
    }
}

