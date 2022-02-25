package will.zhang.UsingTree.PopulatingNextRightPointersInEachNode116;

import will.zhang.util.Node;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/25
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);

        return root;
    }

    public void connectTwoNode(Node node1, Node node2) {
        if (node1 == null) {
            return;
        }
        node1.next = node2;

        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);
    }
}
