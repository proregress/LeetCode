package dp.买卖股票.L0121_买卖股票的最佳时机;

/***
  暴力思想：
  初始状态时min最小值为price[0],然后从index=1处开始向后遍历，
  min要是>=price[i], 那么更新min
  min要是< price[i], 那么算出差值，和ans比谁更小，更新ans
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {7,1,4,6,3};
        int ans = maxProfit(nums);
        System.out.println("ans = " + ans);
    }
    public static int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(min >= prices[i]){
                min = prices[i];
            }else {
                int diff = prices[i] - min;
                ans = Math.max(diff, ans);
            }
        }
        return ans;
    }
}
