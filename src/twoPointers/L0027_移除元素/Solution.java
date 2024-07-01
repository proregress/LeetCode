package twoPointers.L0027_移除元素;

class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 1;

        while (right <= nums.length) {
            int leftN = nums[left];

            if (right == nums.length) {
                int last = nums[right - 1];
                if (last != val) {
                    return right;
                } else {
                    return left;
                }
            } else {
                int rightN = nums[right];
                if (leftN == val) {
                    if (rightN != val) {
                        nums[left] = rightN;
                        nums[right] = val;
                        left++;
                        right = left + 1;
                    } else {
                        right++;
                    }

                } else {
                    left++;
                    right = left + 1;
                }
            }
        }
        return left;
    }
}
