package 二叉树.L0096_不同的二叉搜索树;

/**
 * 递归: 但是没有用动态规划的备忘录，因此超出时间限制。
 */
public class Solution {
    public int numTrees(int n) {
        return count(1, n);
    }

    private int count(int low, int hi){
        //base case，显然当lo > hi闭区间[lo, hi]肯定是个空区间，也就对应着空节点 null，虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0。
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
