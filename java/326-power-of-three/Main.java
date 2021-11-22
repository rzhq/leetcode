class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1 || n == 3) return true;
        else if (n < 3 || n % 3 != 0) return false;
        else return isPowerOfThree(n / 3);
    }
}

public class Main {
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.printf("%s %s\n", s.isPowerOfThree(0), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(1), true);
        System.out.printf("%s %s\n", s.isPowerOfThree(2), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(3), true);
        System.out.printf("%s %s\n", s.isPowerOfThree(4), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(5), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(6), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(7), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(8), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(9), true);
        System.out.printf("%s %s\n", s.isPowerOfThree(10), false);
        System.out.printf("%s %s\n", s.isPowerOfThree(27), true);
        System.out.printf("%s %s\n", s.isPowerOfThree(81), true);
    }
}
