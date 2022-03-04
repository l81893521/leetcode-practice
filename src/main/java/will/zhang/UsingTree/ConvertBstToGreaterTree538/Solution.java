package will.zhang.UsingTree.ConvertBstToGreaterTree538;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/3/3
 */
public class Solution {

    int max = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        max += root.val;
        root.val = max;
        convertBST(root.left);
        return root;
    }
}
