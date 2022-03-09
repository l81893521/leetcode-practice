package will.zhang.UsingLinkedList.DeleteNodeInALinkedList237;

import will.zhang.util.ListNode;

/**
 * @author will
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }
}
