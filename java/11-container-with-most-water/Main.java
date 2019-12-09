class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = 0, k = height.length-1;
        int maxArea = getArea(height, i, k);
        while (i < k) {
            if (height[i] < height[k]) {
                j = i + 1;
                while (j < k && height[j] < height[i]) {
                    j += 1;
                }
                i = j;
            } else {
                j = k - 1;
                while (i < j && height[j] < height[k]) {
                    j -= 1;
                }
                k = j;
            }
            maxArea = Math.max(maxArea, getArea(height, i, k));
        }
        return maxArea;
    }

    int getArea(int[] height, int i, int j) {
        return ( j - i ) * Math.min(height[i], height[j]);
    }
}

public class Main {
    public static void main(String[] args) {
        // int[] input = {1,8,6,2,5,4,8,3,7};
        int[] input = {1,1};
        Solution s = new Solution();
        // int r = s.getArea(input, 0, 1);
        int r = s.maxArea(input);
        System.out.println(r);
    }
}
