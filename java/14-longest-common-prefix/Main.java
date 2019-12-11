// start  2019-12-11 18:38:51
// finish 2019-12-11 19:13:50

import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = "";
        if ( strs.length < 1 ) return pre;
        char c;
        for ( int i = 0; i < strs[0].length(); i++ ) {
            c = strs[0].charAt(i);
            for ( int j = 0; j < strs.length; j++ ) {
                if ( i >= strs[j].length() || c != strs[j].charAt(i) ) { return pre; }
            }
            pre += c;
        }
        return pre;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] input;
        input = new String[] {"flower","flow","flight"};
        check(input);
        input = new String[] {"flower","f","flow","flight"};
        check(input);
        input = new String[] {"dog","racecar","car"};
        check(input);
        input = new String[] {};
        check(input);
    }
    
    static void check(String[] input) {
        Solution s = new Solution();
        String ret = s.longestCommonPrefix(input);
        System.out.println(ret);
    }
}

