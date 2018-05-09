package will.zhang.UsingLinkedList.RemoveLinkedListElements203;

/**
 * @Author will
 * @Date 2018/5/9 0009 下午 8:39
 **/
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        //使用虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //检查非头节点是否包含val
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 6, 3, 4, 1, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode result = new Solution2().removeElements(listNode, 1);
        System.out.println(result);
    }
}
