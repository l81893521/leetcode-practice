package will.zhang.UsingArray.MoveZero283;

/**
 * Leetcode 283
 * Move Zeroes
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 * 原地解决该问题
 * Created by Will.Zhang on 2018/2/27 0027 17:51.
 */
public class Solution1 {

    public void moveZeroes(int[] nums){
        //nums中, [0...k)的元素均为非0元素
        int k = 0;
        //遍历到第i个元素后, 保证[0...i]中所有非0元素, 都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[k++] = nums[i];
            }
        }

        //将剩余的位置放置为0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        (new Solution1()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
