package dfs.L0070_爬楼梯;

/**
 * dfs又双超时！
 *
 * 配合L0131_分割回文串一起看，那一题是给定字符串s，枚举其所有可能的子串集合，子串长度不固定
 * 这一题是给定一个数字，枚举用1和2组成该数字的所有排列情况
 */
public class Solution {
    int ans;
    public int climbStairs(int n){
        dfs(n);
        return ans;
    }

    public void dfs(int n){
        if(n < 0) return;
        if(n == 0){
            ans++;
            return;
        }
        dfs(n-1);
        dfs(n-2);
    }
}
