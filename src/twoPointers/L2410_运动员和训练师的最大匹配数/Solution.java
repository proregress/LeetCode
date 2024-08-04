package twoPointers.L2410_运动员和训练师的最大匹配数;

import java.util.Arrays;

/**
 * 双指针，不能用两层for循环，而是if内判断两个指针是否同时未到末尾。
 */
public class Solution {
    public static void main(String[] args) {
        int[] players = {1,1,1};
        int[] trainers = {10};
        int ans = matchPlayersAndTrainers(players, trainers);
        System.out.println("ans = " + ans);
    }
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int ans = 0;
        int i = 0, j = 0;
        while(i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                ans++;
                i++;
                j++;
            }else {
                j++;
            }

        }
        return ans;
    }
}
