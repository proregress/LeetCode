package stack.单调栈.L0496_下一个更大元素1;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        //nums2=[1,3,4,2]
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1 ; i >= 0 ;i--){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }

        for(int i = 0 ; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        int[] ints = nextGreaterElement(nums1, nums2);
    }
}
