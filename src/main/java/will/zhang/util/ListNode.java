package will.zhang.util;
/**
  * @author will.zjw
  * @date 2019-11-13 20:17
  */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        this.val = x;
    }

    public static ListNode create(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode listNode = dummy;
        for (int i = 0; i < array.length; i++) {
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
        }
        return dummy.next;
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
