package hj.odOnlineExam.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] hill_map = Arrays.stream(sc.nextLine().split(",")).mapToInt(i -> Integer.valueOf(i)).toArray();
        int ans = count_peaks(hill_map);
        System.out.println(ans);
    }
    /**
     * 返回地图中山峰的数量
     * @param hill_map int整型一维数组 地图数组(长度大于1)
     * @return int整型
     */
    public static int count_peaks (int[] hill_map) {
        int count = 0;
        // [1,length-2]的判断
        for (int i = 1; i < hill_map.length-1; i++) {
            if(hill_map[i] > hill_map[i-1] && hill_map[i] > hill_map[i+1]){
                count++;
            }
        }
        //边界判断：0，length-1
        if(hill_map[0] > hill_map[1]) count++;
        if(hill_map[hill_map.length-1] > hill_map[hill_map.length-2]) count++;
        return count;
    }
}