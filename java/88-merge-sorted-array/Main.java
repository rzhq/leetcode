// start  19-12-10 16:22
// finish 19-12-10 17:20
import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m--; n--;
        while ( m >= 0 && n >= 0 ) {
            if ( nums1[m] > nums2[n] ) {
                nums1[k--] = nums1[m--];
            } else {
                nums1[k--] = nums2[n--];
            }
        }
        while ( n >= 0 ) { nums1[k--] = nums2[n--]; }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if ( m == 0 ) {
            for ( int i = 0; i < nums2.length; i++ ) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if ( n == 0 ) { return; }
        int i = 0, j = 0;
        int[] ret = new int[m+n];
        int c = 0;
        while ( i < m && j < n ) {
            if ( nums1[i] < nums2[j] ) {
                ret[c++] = nums1[i++];
            } else {
                ret[c++] = nums2[j++];
            }
        }
        if ( i >= m ) {
            while ( j < n ) { ret[c++] = nums2[j++]; }
        } else if ( j >= n ) {
            while ( i < m ) { ret[c++] = nums1[i++]; }
        }
        for ( i = 0; i < ret.length; i++ ) {
            nums1[i] = ret[i];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {2,4,5};
        s.merge(n1, 3, n2, 3);
        System.out.println(Arrays.toString(n1));
    }
}

