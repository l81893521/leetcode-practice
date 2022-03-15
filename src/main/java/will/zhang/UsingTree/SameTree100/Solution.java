package will.zhang.UsingTree.SameTree100;

import will.zhang.util.TreeNode;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        boolean one = isSameTree(p.left, q.left);
        boolean two = isSameTree(p.right, q.right);

        return one && two;
    }
}
