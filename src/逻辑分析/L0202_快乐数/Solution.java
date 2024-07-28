package 逻辑分析.L0202_快乐数;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int n = 2;
        boolean happy = isHappy(n);
        System.out.println("happy = " + happy);
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        String s = String.valueOf(n);
        int squareSum = 0;
        for(char c : s.toCharArray()){
            squareSum = squareSum + (c-'0') * (c-'0');
        }
        if (squareSum == 1) return true;

        while (squareSum != 1){
            int newSum = 0;
            for(char c : String.valueOf(squareSum).toCharArray()){
                newSum = newSum + (c-'0') * (c-'0');
            }
            if (set.contains(newSum)){
                return false;
            }
            squareSum = newSum;
            set.add(newSum);
        }
        return true;
    }
}
