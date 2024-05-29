package brainteaser.L2028_找出缺失的观测数据;

import java.util.Arrays;

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // commit：基础数学？脑筋急转弯？
        // 知道数组size，数组所有元素和，每个元素在1-6之间，返回数组可能的情况之一即可。
        int[] ans = new int[n];

        int totalSum = (rolls.length + n)*mean;
        int rollSum = 0;
        for(int roll : rolls){
            rollSum = rollSum + roll;
        }
        int nSum = totalSum - rollSum;

        //得到数组n的总和，求数组，与模的值有关
        // if(nSum / n >= 1 && nSum / n <= 6){
        if(nSum>=n*1 && nSum <= n * 6){
            int mod = nSum % n;
            int avg = nSum / n;
            Arrays.fill(ans , avg);
            for(int i = 0; i < mod; i++){
                ans[i] = ans[i] + 1;
            }
        }else {
            ans = new int[0];
        }
        return ans;

    }
}