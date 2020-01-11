// start    2020-01-11 17:57:30
// finish   2020-01-11 18:07:03

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false;
        int n = s.length();
        int[] table = new int[26];
        for ( int i = 0; i < n; ++i ) {
            table[s.charAt(i)-'a']++;
            table[t.charAt(i)-'a']--;
        }
        for ( int i : table ) {
            if ( i != 0 ) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        check("anagram", "nagaram", true);
        check("car", "rat", false);
    }
    
    static void check(String src, String tgt, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isAnagram(src, tgt);
        System.out.printf("%s %s\n", ret, out);
    }
}

