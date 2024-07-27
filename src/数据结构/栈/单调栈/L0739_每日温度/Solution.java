package 数据结构.栈.单调栈.L0739_每日温度;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println("ints = " + ints);
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] nextGreater = new int[length];
        // 苯方法，先求出下一个更大数字的数组，再循环一次匹配到是几天以后
        Stack<Integer> stack = new Stack<>();

        for(int i = length-1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= temperatures[i]){
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(temperatures[i]);
        }

        // 增加map用于记录某元素出现的index，避免重复判断
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int i1 = nextGreater[i];
            // 先到map里找有没有存下一个更大元素的index
            if(map.containsKey(i1) && map.get(i1) > i){
                ans[i] = map.get(i1)-i;
                continue;
            }
            // 如果map里没有存，或者存了但是当前元素已经超过了那个index，则重新找
            for (int j = i+1; j < length; j++) {
                if(temperatures[j] == i1){
                    map.put(i1, j);
                    ans[i] = j-i;
                    break;
                }
            }
        }

        return ans;
    }
}
