package 数据结构.栈.L1541_平衡括号字符串的最少插入次数;

import java.util.Stack;

/**
 * 倒着遍历入栈不行，下例错：
 * Strin s = "(()))(()))()())))"
 *
 * 【还得正着入栈】
 */
public class Solution_Wrong {
    public static int minInsertions(String s) {
        int ans = 0;

        // 倒着遍历
        Stack<Character> rightStack = new Stack<>();
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ')'){
                rightStack.push(')');
            }else if(s.charAt(i) == '(' && rightStack.size() >= 2){
                rightStack.pop();
                rightStack.pop();
            }else if(s.charAt(i) == '(' && rightStack.size() == 1){
                rightStack.pop();
                ans = ans + 1;
            }else if(s.charAt(i) == '(' && rightStack.size() == 0){
                ans = ans + 2;
            }
        }

        if(rightStack.size() % 2 == 0){
            ans = ans + rightStack.size() / 2;
        }else{
            ans = ans + (rightStack.size() - 1) / 2 + 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "()";
        int i = minInsertions(s);
        System.out.println("i = " + i);
    }
}
