package will.zhang.UsingTree.FlattenBinaryTreeToLinkedList114;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/28
 */
public class Solution {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode rightTree = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = rightTree;
    }
}
