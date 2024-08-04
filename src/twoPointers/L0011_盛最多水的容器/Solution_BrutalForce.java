package twoPointers.L0011_盛最多水的容器;

/**
 * 暴力解，双层循环，超时
 */
public class Solution_BrutalForce {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println("i = " + i);
    }
    public static int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int len = j - i;
                int hi = Math.min(height[i], height[j]);
                ans = Math.max(ans, len*hi);
            }
        }

        return ans;
    }
}
