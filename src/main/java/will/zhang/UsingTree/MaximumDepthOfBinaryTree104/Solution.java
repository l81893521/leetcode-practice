package will.zhang.UsingTree.MaximumDepthOfBinaryTree104;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/22
 */
public class Solution {

    int depth;
    int res;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            res = Math.max(depth, res);
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    public static void main(String[] args) {

    }
}
