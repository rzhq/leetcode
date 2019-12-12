// start  2019-12-12 09:37:13
// finish 2019-12-12 10:30:07

import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        if ( needle == null || needle.isEmpty()) return 0;
        if ( haystack == null || haystack.isEmpty() || needle.length() > haystack.length() ) return -1;
        for ( int i = 0; i <= haystack.length() - needle.length(); i++ ) {
            for ( int j = 0; j < needle.length(); j++ ) {
                if ( haystack.charAt(i+j) != needle.charAt(j) ) break;
                if ( j == needle.length() - 1 ) return i;
            }
            if ( haystack.length() - i < needle.length() ) return -1;
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        String input;
        input = ""; check(input, "a", -1);
        input = "aaaaaaa"; check(input, "bbbbbbb", -1);
        input = "a"; check(input, "a", 0);
        input = "a"; check(input, "", 0);
        input = "abcd"; check(input, "ab", 0);
        input = "abcd"; check(input, "bcd", 1);
        input = "aaab"; check(input, "ab", 2);
        input = "aaab"; check(input, "b", 3);
    }
    
    static void check(String input, String target, int output) {
        Solution s = new Solution();
        int r = s.strStr(input, target);
        System.out.printf("%s %d\n", r, output);
    }
}

