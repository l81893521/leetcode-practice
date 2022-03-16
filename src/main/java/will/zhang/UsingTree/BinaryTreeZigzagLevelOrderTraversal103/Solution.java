package will.zhang.UsingTree.BinaryTreeZigzagLevelOrderTraversal103;

import will.zhang.util.TreeNode;

import java.util.*;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        boolean flag = false;

        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();

            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodes.poll();

                if (flag) {
                    level.addLast(treeNode.val);
                } else {
                    level.addFirst(treeNode.val);
                }

                if (treeNode.left != null) {
                    treeNodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.offer(treeNode.right);
                }

            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }

}
