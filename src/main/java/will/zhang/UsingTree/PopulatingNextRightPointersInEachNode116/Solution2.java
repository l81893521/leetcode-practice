package will.zhang.UsingTree.PopulatingNextRightPointersInEachNode116;

import will.zhang.util.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/25
 */
public class Solution2 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node rightNode = null;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node leftNode = queue.poll();
                leftNode.next = rightNode;
                rightNode = leftNode;

                if (leftNode.right != null) {
                    queue.offer(leftNode.right);
                }
                if (leftNode.left != null) {
                    queue.offer(leftNode.left);
                }
            }
        }
        return root;
    }
}
