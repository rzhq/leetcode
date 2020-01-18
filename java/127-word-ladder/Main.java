// start    2020-01-18 14:44:25
// finish   2020-01-18 15:14:36

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int depth = 1;
        
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int j=0; j<size; j++ ) {
                String currWord = queue.poll();
                if ( currWord.equals(endWord) ) return depth;
                for ( int i=0; i<currWord.length(); i++ ) {
                    char c = currWord.charAt(i);
                    char[] tempWord = currWord.toCharArray();
                    for ( char t='a'; t<='z'; t++ ) {
                        tempWord[i] = t;
                        String temp = String.valueOf(tempWord);
                        if ( set.contains(temp) ) {
                            queue.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
            depth++;
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        check("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"), 5);
    }
    
    static void check(String b, String e, List<String> l, int out) {
        Solution s = new Solution();
        int ret = s.ladderLength(b, e, l);
        System.out.printf("%d %d\n", ret, out);
    }
}

