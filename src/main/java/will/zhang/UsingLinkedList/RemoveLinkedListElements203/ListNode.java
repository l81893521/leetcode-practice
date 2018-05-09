package will.zhang.UsingLinkedList.RemoveLinkedListElements203;

/**
 * @Author will
 * @Date 2018/5/9 0009 下午 8:56
 **/
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x){
        this.val = x;
    }
    ListNode(int[] arr){
        if(arr.length < 0){
            throw new IllegalArgumentException("arr length must be large than zero");
        }

        ListNode listNode = this;
        listNode.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            builder.append(cur.val + "->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
