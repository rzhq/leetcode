// start    2020-01-11 20:21:58
// finish   2020-01-11 20:39:18

import java.util.*;

class Solution {
    public String getHint(String secret, String guess) {
        int[] list = new int[10];
        for ( int i = 0; i < secret.length(); ++i ) {
            list[secret.charAt(i)-'0']++;
        }
        int a = 0, b = 0;
        for ( int i = 0; i < guess.length(); ++i ) {
            if ( i < secret.length() && secret.charAt(i) == guess.charAt(i) ) {
                a++;
            }
            if ( list[guess.charAt(i)-'0'] > 0 ) {
                list[guess.charAt(i)-'0']--;
                b++;
            }
        }
        return a+"A"+(b-a)+"B";
    }
}

public class Main {
    public static void main(String[] args) {
        check("1807", "7810", "1A3B");
        check("1123", "0111", "1A1B");
    }
    
    static void check(String secret, String guess, String out) {
        Solution s = new Solution();
        String ret = s.getHint(secret, guess);
        System.out.printf("%s %s\n", ret, out);
    }
}

