package 数据结构.数组.L0118_杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println("generate = " + generate);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
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
        return result;
    }
}
