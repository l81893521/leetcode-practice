package will.zhang.UsingTree.BinarySearchTreeToGreaterSumTree1038;

import will.zhang.util.TreeNode;

/**
 * @author will
 */
public class Solution {

    int max = 0;

    public TreeNode bstToGst(TreeNode root) {

        if (root == null) {
            return null;
        }

        bstToGst(root.right);
        max += root.val;
        root.val = max;
        bstToGst(root.left);

        return root;
    }
}
