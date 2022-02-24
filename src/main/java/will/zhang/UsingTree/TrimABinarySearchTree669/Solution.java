package will.zhang.UsingTree.TrimABinarySearchTree669;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/24
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val < low || root.val > high) {
            return remove(root);
        }
        return root;
    }

    private TreeNode remove(TreeNode root) {
        if (root.left == null) {
            TreeNode rightNode = root.right;
            root.right = null;
            return rightNode;
        }

        if (root.right == null) {
            TreeNode leftNode = root.left;
            root.left = null;
            return leftNode;
        }

        TreeNode successor = minimum(root.right);
        successor.left = removeMin(root.left);
        successor.right = root.right;

        root.left = null;
        root.right = null;

        return successor;
    }

    private TreeNode minimum(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    private TreeNode removeMin(TreeNode root) {
        if (root == null) {
            TreeNode leftNode = root.left;
            root.left = null;
            return leftNode;
        }
        return removeMin(root.left);
    }
}
