package will.zhang.SwordTowardsOffer.CongWeiDaoTouDaYinLianBiaoLcof06;

import will.zhang.util.ListNode;

/**
 * @author will
 */
public class Solution {

    int[] res;
    int i = 0;

    public int[] reversePrint(ListNode head) {
        reverse(head, 0);
        return res;
    }

    public void reverse(ListNode head, int n) {
        if (head == null) {
            res = new int[n];
            return;
        }
        reverse(head.next, n + 1);
        res[i] = head.val;
        i++;
    }
}
