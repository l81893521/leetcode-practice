package will.zhang.UsingTree.InsertIntoABinarySearchTree701;

import will.zhang.util.TreeNode;

/**
 * @author will
 */
public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
            return root;
        } else {
            root.right = insertIntoBST(root.right, val);
            return root;
        }
    }
}
