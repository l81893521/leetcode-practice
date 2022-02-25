package will.zhang.UsingTree.FindLargestValueInEachTreeRow515;

import will.zhang.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/25
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int rowMax = Integer.MIN_VALUE;
            int rowSize = queue.size();
            for (int i = 0; i < rowSize; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.val > rowMax) {
                    rowMax = treeNode.val;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            list.add(rowMax);
        }
        return list;
    }
}
