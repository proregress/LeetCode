package 数据结构.数组.L0119_杨辉三角2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> generate = getRow(3);
        System.out.println("generate = " + generate);
    }
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= rowIndex+1; i++) {
            List<Integer> level = new ArrayList<>();
            if(i == 1){
                level.add(1);
            }else if (i == 2){
                level.add(1);
                level.add(1);
            }else {
                level.add(1);
                for (int j = 1; j < i-1; j++) {
                    List<Integer> pre = result.get(result.size() - 1);
                    level.add(pre.get(j-1) + pre.get(j));
                }
                level.add(1);
            }
            result.add(level);
        }
        return result.get(rowIndex);
    }
}
