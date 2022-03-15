package will.zhang.UsingTree.SymmetricTree101;

import will.zhang.util.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }

        if (leftTree == null || rightTree == null || leftTree.val != rightTree.val) {
            return false;
        }
        boolean left = isSymmetric(leftTree.left, rightTree.right);
        boolean right = isSymmetric(leftTree.right, rightTree.left);
        return left && right;
    }

}
