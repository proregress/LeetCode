package 二叉树.L0654_最大二叉树;

import 二叉树.entity.TreeNode;

/**
 * 思路已经正确，但是对于下标的取值还是有疑惑
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) { //  [3,2,1,6,0,5]

        return traverse(0, nums.length-1, nums); //细节1： nums的length是取不到的，所以要减1

    }

    private TreeNode traverse(int begin, int end, int[] nums){
        if(begin > end ){
            return null;
        }
        //找到最大值的下标
        int max = nums[begin];
        int index = begin;
        for(int i = begin; i <= end; i++){
            int ret = nums[i];
            if(ret > max){
                max = ret;
                index = i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = max;
        root.left = traverse(begin, index-1, nums); //细节2：取到最大值前面一个数
        root.right = traverse(index + 1, end, nums);

        return root;
    }
}











