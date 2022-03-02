package will.zhang.UsingTree.KthSmallestElementInABst230;

import will.zhang.util.TreeNode;

/**
 * @author will
 */
public class Solution {

    int rank = 0;

    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
        }
        inorder(root.right, k);
    }
}
