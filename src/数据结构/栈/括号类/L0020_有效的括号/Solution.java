package 数据结构.栈.括号类.L0020_有效的括号;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xufan
 * @since 2024/07/23 21:33
 */

public class Solution {
    public static void main(String[] args) {
        String s = ")[]{}[}";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length; i++){
            char c = chars[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false; //重要

                Character pop = stack.pop();
                if(c == ')' && pop != '('){
                    return false;
                }else if(c == ']' && pop != '['){
                    return false;
                }else if(c == '}' && pop != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
