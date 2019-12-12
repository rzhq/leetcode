// start  2019-12-12 11:17:16
// finish 2019-12-12 11:52:16

import java.util.*;

class Solution {
    public String countAndSay(int n) {
        StringBuilder ret = new StringBuilder("1");
        if ( n < 2 ) return ret.toString();
        for ( int i = 1; i < n; i++ ) {
            StringBuilder tmp = new StringBuilder();;
            int j = 0;
            while ( j < ret.length() ) {
                char ch = ret.charAt(j++);
                int c = 1;
                while ( j < ret.length() ) {
                    if ( ch == ret.charAt(j) ) { c++; j++; }
                    else break;
                }
                tmp.append(c).append(ch);
            }
            ret = tmp;
        }
        return ret.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i=0; i<10; i++) check(i);
    }
    
    static void check(int input) {
        Solution s = new Solution();
        String ret = s.countAndSay(input);
        System.out.printf("%s %d\n", ret, ret.length());
    }
}

