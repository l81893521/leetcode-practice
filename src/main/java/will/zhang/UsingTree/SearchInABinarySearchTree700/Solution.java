package will.zhang.UsingTree.SearchInABinarySearchTree700;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/3/3
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
