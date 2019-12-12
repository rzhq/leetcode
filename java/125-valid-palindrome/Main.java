// start  2019-12-12 16:05:09
// finish 2019-12-12 17:15:53

import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        if ( s.isEmpty() ) return true;
        int i = 0, j = s.length() - 1;
        while ( i < j ) {
            char ci = s.charAt(i), cj = s.charAt(j);
            if ( ci < '0' ||
                (ci > '9' && ci < 'A') ||
                (ci > 'Z' && ci < 'a') ||
                ci > 'z' ) { i++; continue;}
            if ( cj < '0' ||
                (cj > '9' && cj < 'A') ||
                (cj > 'Z' && cj < 'a') ||
                cj > 'z' ) { j--; continue; }

            if ( ci == cj || (
                    ci > '9' && cj > '9' && (
                        ci + 32 == cj ||
                        ci - 32 == cj
                    )
                )) { i++; j--; continue; }
            return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        check("a");
        check("");
        check("aa");
        check("ababa");
        check("AbaBa");
        check(",a=-=--a");
        check(",a3=-=43--a");
        check(",a3=a-=43--a");
        check(",...,.b,a3=a-=43--a");
        check("A man, a plan, a canal: Panama");
        check("race a car");
    }
    
    static void check(String input) {
        Solution s = new Solution();
        boolean ret = s.isPalindrome(input);
        System.out.printf("%s\n", ret);
    }
}

