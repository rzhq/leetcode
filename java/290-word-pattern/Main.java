// start    2020-01-10 18:08:40
// finish   2020-01-10 18:51:31

import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if ( pattern.length() != arr.length ) return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for ( int i = 0; i < arr.length; i++ ) {
            String s = map1.put(pattern.charAt(i), arr[i]);
            if ( s != null && !s.equals(arr[i]) ) {
                return false;
            }
            Character c = map2.put(arr[i], pattern.charAt(i));
            if ( c != null && !c.equals(pattern.charAt(i)) ) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        check("abba", "a b b a", true);
    }
    
    static void check(String p, String str, boolean out) {
        Solution s = new Solution();
        boolean ret = s.wordPattern(p, str);
        System.out.printf("%s %s\n", ret, out);
    }
}

