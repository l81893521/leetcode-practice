package will.zhang.UsingTree.DeleteNodeInABst450;

import will.zhang.util.TreeNode;

/**
 * @author will
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // delete

            if (root.right == null) {
                //no right tree node
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            } else if (root.left == null) {
                //no left tree node
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            } else {
                //has left and right tree node

                //find successor
                TreeNode successor = findMinimum(root.right);
                successor.right = removeMin(root.right);
                successor.left = root.left;

                root.left = null;
                root.right = null;

                return successor;
            }
        }
    }

    private TreeNode removeMin(TreeNode root) {
        if (root.left == null) {
            TreeNode rightNode = root.right;
            root.right = null;
            return rightNode;
        }

        root.left = removeMin(root.left);
        return root;
    }

    private TreeNode findMinimum(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMinimum(root.left);
    }
}
