package will.zhang.UsingTree.MaximumDepthOfBinaryTree104;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/22
 */
public class Solution2 {

    int res;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        res = Math.max(leftMax, rightMax) + 1;
        return res;
    }

    public static void main(String[] args) {

    }
}
