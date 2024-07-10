package 数据结构.栈.L0921_使括号有效的最小添加;

import java.util.Stack;

public class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;

        /**
         * 遇到左括号就入栈
         * 遇到右括号：如果栈内为空，则表示需要添加一个左括号
         *             如果栈内不为空，则pop()
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(s.charAt(i) == ')' && stack.isEmpty()){
                ans++;
            }else if(s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
            }
        }

        ans = ans + stack.size();

        return ans;
    }
}
