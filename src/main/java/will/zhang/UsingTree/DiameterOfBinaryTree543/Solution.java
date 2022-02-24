package will.zhang.UsingTree.DiameterOfBinaryTree543;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/24
 */
public class Solution {

    int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxDiameter;
    }

    private int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);


        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }
}
