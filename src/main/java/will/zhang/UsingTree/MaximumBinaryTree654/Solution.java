package will.zhang.UsingTree.MaximumBinaryTree654;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/28
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = findMaxIndex(nums, left, right);
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        treeNode.left = constructMaximumBinaryTree(nums, left, maxIndex - 1);
        treeNode.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);

        return treeNode;
    }

    private int findMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
