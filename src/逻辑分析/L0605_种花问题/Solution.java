package 逻辑分析.L0605_种花问题;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,1};
        boolean b = canPlaceFlowers(nums, 2);
        System.out.println("b = " + b);
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        /**
         * 从左到右遍历数组，能种花就立刻种花。
         * 如何判断能否种花？由于「花不能种植在相邻的地块上」，如果要在下标 i 处种花，需要满足 flowerbed[i−1],flowerbed[i],flowerbed[i+1] 均为 0。
         * 每种一朵花，就把 n 减一。如果最后 n≤0，则返回 true，否则返回 false。
         * 为了简化判断逻辑，可以在数组的开头和末尾各插入一个 0。
         */
        int[] a = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i++) {
            a[i+1] = flowerbed[i];
        }
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] == 0 && a[i] == 0 && a[i + 1] == 0) {
                a[i] = 1; // 种花！
                n--;
            }
        }
        return n <= 0;
    }
}
