// start    2020-01-11 14:50:49
// finish   2020-01-11 15:23:58

import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if ( s.length() != t.length() ) return false;
        int[] m1 = new int[256], m2 = new int[256];
        for ( int i = 0; i < s.length(); ++i ) {
            if ( m1[s.charAt(i)] != m2[t.charAt(i)] ) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        check("egg", "add", true);
        check("foo", "bar", false);
        check("paper", "title", true);
        check("ab", "aa", false);
    }
    
    static void check(String src, String tgt, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isIsomorphic(src, tgt);
        System.out.printf("%s %s\n", ret, out);
    }
}

