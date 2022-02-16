package will.zhang.UsingLinkedList.LinkedListCycle141;
/**
  * @author will.zjw
  * @date 2019-11-13 20:17
  */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        this.val = x;
    }

    public static ListNode create(int[] array) {
        if (array.length == 0) {
            return new ListNode();
        }
        ListNode head = new ListNode(array[0]);
        ListNode listNode = head;
        for (int i = 1; i < array.length; i++) {
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
        }
        return head;
    }

    public ListNode get(int index) {
        ListNode cur = this;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val);
            if (cur.next != null) {
                stringBuilder.append("->");
            }
            cur = cur.next;
        }
        return stringBuilder.toString();
    }
}
