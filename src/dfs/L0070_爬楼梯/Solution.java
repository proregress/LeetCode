package dfs.L0070_爬楼梯;

/**
 * dfs又双超时！
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
