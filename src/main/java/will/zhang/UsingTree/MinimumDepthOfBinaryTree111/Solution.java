package will.zhang.UsingTree.MinimumDepthOfBinaryTree111;

import will.zhang.util.TreeNode;

/**
 * @author will
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if (leftMin == 0) {
            return rightMin + 1;
        }
        if (rightMin == 0) {
            return leftMin + 1;
        }
        return Math.min(leftMin, rightMin) + 1;
    }
}
