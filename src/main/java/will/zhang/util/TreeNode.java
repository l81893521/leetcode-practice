package will.zhang.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/22
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode generateTreeNode(List<Integer> lists) {
        if (lists.isEmpty()) {
            return new TreeNode();
        }
        // add root
        this.val = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            add(this, lists.get(i));
        }

        return this;
    }

    public TreeNode add(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        int leftRight = (int)(Math.random() * 2 + 1);

        if (leftRight == 1) {
            root.left = add(root.left, num);
        } else {
            root.right = add(root.right, num);
        }
        return root;
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        Collections.addAll(lists, 1, 2, 3, 4, 5, 6);
        TreeNode treeNode = new TreeNode().generateTreeNode(lists);
        TreeNode.print(treeNode);
    }
}
