package twoPointers.L0011_盛最多水的容器;

public class Solution_TwoPointers {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println("i = " + i);
    }
    public static int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length-1;
        while(l < r){
            int area = (r-l) * Math.min(height[l], height[r]);
            ans = Math.max(ans, area);
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }

        return ans;
    }
}
