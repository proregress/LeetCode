package 数据结构.栈.L0946_验证栈序列;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 , j = 0 ; i < pushed.length ; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
