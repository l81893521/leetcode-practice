package will.zhang.UsingLinkedList.RemoveLinkedListElements203;

/**
 * @Author will
 * @Date 2018/5/9 0009 下午 8:39
 **/
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        //使用递归
        head.next =  removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 6, 3, 4, 1, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode result = new Solution3().removeElements(listNode, 1);
        System.out.println(result);
    }
}
