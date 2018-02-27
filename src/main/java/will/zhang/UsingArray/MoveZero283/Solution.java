package will.zhang.UsingArray.MoveZero283;

import java.util.ArrayList;

/**
 * Leetcode 283
 * Move Zeroes
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * Created by Will.Zhang on 2018/2/27 0027 16:47.
 */
public class Solution {

    public void moveZeroes(int[] nums){
        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

        //将所有非0元素放进nonZeroElements中
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nonZeroElements.add(nums[i]);
            }
        }
        //把非0元素重新赋给nums
        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }
        //把nums剩余的位置置成0
        for (int i = nonZeroElements.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        (new Solution()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
