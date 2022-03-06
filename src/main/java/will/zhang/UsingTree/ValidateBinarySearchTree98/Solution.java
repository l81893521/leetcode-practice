package will.zhang.UsingTree.ValidateBinarySearchTree98;

import will.zhang.util.TreeNode;

/**
 * @author will
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        boolean left = isValidBST(root.left, min, root);
        boolean right = isValidBST(root.right, root, max);
        return left && right;
    }
}
