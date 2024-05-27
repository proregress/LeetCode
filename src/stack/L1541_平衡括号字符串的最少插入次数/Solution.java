package stack.L1541_平衡括号字符串的最少插入次数;

import java.util.Stack;

/**
 * 正着入栈
 * 主要是判断是否后面两个都是右括号有点麻烦
 */
public class Solution {
    public static int minInsertions(String s) {
        int ans = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push('(');
            }else if (ch == ')' && i+1<s.length() && s.charAt(i+1) == ')'){
                if (stack.isEmpty()){
                    ans = ans + 1;
                }else if(!stack.isEmpty()){
                    stack.pop();
                }
                i++;
            }else if (ch == ')' && i+1<s.length() && s.charAt(i+1) == '('){
                if (stack.isEmpty()){
                    ans = ans + 2;
                }else if(!stack.isEmpty()){
                    stack.pop();
                    ans = ans + 1;
                }
            }else if (ch == ')' && i+1 >= s.length()){
                if (stack.isEmpty()){
                    ans = ans + 2;
                }else if(!stack.isEmpty()){
                    stack.pop();
                    ans = ans + 1;
                }
            }
        }

        ans = ans + stack.size() * 2;

        return ans;
    }

    public static void main(String[] args) {
        String s = "(()))(()))()())))";
        int i = minInsertions(s);
        System.out.println("i = " + i);
    }
}
