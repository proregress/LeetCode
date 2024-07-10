package 数据结构.栈.单调栈.L1673_找出最具竞争力的子序列;

import java.util.Stack;

public class Solution {
    public static int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < nums.length ; i++){
            while(!stack.isEmpty() && nums[i] < stack.peek() && (stack.size() + nums.length - i > k)){
                stack.pop();
            }
            if(stack.size() < k){
                stack.push(nums[i]);
            }
        }

        for(int i = k-1; i >= 0; i--){
            ans[i] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,3,5,4,9,6};
        int[] ints = mostCompetitive(nums, 7);
        System.out.println("ints = " + ints);
    }
}
