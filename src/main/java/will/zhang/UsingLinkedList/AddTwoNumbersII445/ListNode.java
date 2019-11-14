package will.zhang.UsingLinkedList.AddTwoNumbersII445;
/**
  * @author will.zjw
  * @date 2019-11-13 20:17
  */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
    }

    public static ListNode create(int[] array) {
        ListNode
            head = new ListNode(array[0]);
        ListNode listNode = head;
        for (int i = 1; i < array.length; i++) {
            listNode.next = new ListNode(array[i]);
            listNode = listNode.next;
        }
        return head;
    }
}
