package will.zhang.UsingTree.ConstructBinaryTreeFromInorderAndPostorderTraversal106;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/3/1
 */
public class Solution {

    int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int rootIndex = findRootIndex(inorder, postorder, lo, hi);
        postOrderIndex--;
        TreeNode treeNode = new TreeNode(inorder[rootIndex]);
        treeNode.right = buildTree(inorder, postorder, rootIndex + 1, hi);
        treeNode.left = buildTree(inorder, postorder, lo, rootIndex - 1);
        return treeNode;
    }

    private int findRootIndex(int[] inorder, int[] postorder, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            if (inorder[i] == postorder[postOrderIndex]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        new Solution().buildTree(inorder, postorder);
    }
}
