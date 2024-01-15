package 二叉树.L0096_不同的二叉搜索树;

/**
 * 递归: 但是没有用动态规划的备忘录，因此超出时间限制。
 */
public class Solution {
    public int numTrees(int n) {
        return count(1, n);
    }

    private int count(int low, int hi){
        if(low > hi){
            return 1;
        }
        int res = 0;
        for(int i = low; i <= hi; i++){
            // 以i作为根节点
            int left = count(low, i - 1);
            int right = count(i+1, hi);
            res = res + left * right;
        }
        return res;
    }
}
