package will.zhang.UsingTree.ConstructBinaryTreeFromPreorderAndInorderTraversal105;

import will.zhang.util.TreeNode;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/28
 */
public class Solution {

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int rootIndex = findRootIndex(preorder, inorder, lo, hi);
        preIndex++;

        TreeNode treeNode = new TreeNode(inorder[rootIndex]);
        treeNode.left = buildTree(preorder, inorder, lo, rootIndex - 1);
        treeNode.right = buildTree(preorder, inorder, rootIndex + 1, hi);
        return treeNode;
    }

    private int findRootIndex(int[] preorder, int[] inorder, int lo, int hi) {
        int rootIndex = -1;
        for (int i = lo; i <= hi; i++) {
            if (inorder[i] == preorder[preIndex]) {
                rootIndex = i;
                return rootIndex;
            }
        }
        return rootIndex;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        new Solution().buildTree(preOrder, inOrder);
    }
}
