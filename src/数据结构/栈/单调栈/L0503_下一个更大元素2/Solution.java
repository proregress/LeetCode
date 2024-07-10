package 数据结构.栈.单调栈.L0503_下一个更大元素2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Integer[] 、int[]、ArrayList的相互转换：
 * https://blog.csdn.net/qq_47320647/article/details/122727935
 */
public class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length*2];

        // int[]转Integer[]
        Integer[] Nums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // Integer[]转ArrayList：Collections.addAll()最高效，但是需要Integer[]数组
        ArrayList<Integer> temp = new ArrayList<>(Nums.length);
        Collections.addAll(temp, Nums);

        // 重复一遍数组，加在后面
        temp.addAll(temp);

        // nums = [1,2,3,4,3,1,2,3,4,3]
        Stack<Integer> stack = new Stack<>();
        for(int i = temp.size()-1; i >= 0; i--){
            while (!stack.isEmpty() && temp.get(i) >= stack.peek()){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(temp.get(i));
        }

        // 取ans数组的前一半
        int[] ANS = Arrays.copyOfRange(ans, 0, length);

        return ANS;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,3};
        int[] ints = nextGreaterElements(nums);
        System.out.println("ints = " + ints);
    }
}
