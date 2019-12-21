// start  2019-12-21 21:46:11
// finish 2019-12-21 22:25:03

import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if ( triangle.size() < 1 || triangle.get(0).size() < 1 ) return 0;
        if ( triangle.size() == 1 ) return triangle.get(0).get(0);
        int[] aux = new int[triangle.size()+1];
        for ( int i = triangle.size() - 1; i >= 0; i-- ) {
            List<Integer> l = triangle.get(i);
            for ( int j = 0; j <= i; j++ ) {
                aux[j] = l.get(j) + Math.min(aux[j], aux[j+1]);
            }
        }
        return aux[0];
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> tri;
        tri = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3,4),
            Arrays.asList(6,5,7),
            Arrays.asList(4,1,8,3)
        );
        check(tri, 11);
        tri = Arrays.asList(Arrays.asList(2));
        check(tri, 2);
        tri = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3,4)
        );
        check(tri, 5);
    }
    
    static void check(List<List<Integer>> triangle, int out) {
        Solution s = new Solution();
        int ret = s.minimumTotal(triangle);
        System.out.printf("%d %d\n", ret, out);
    }
}

