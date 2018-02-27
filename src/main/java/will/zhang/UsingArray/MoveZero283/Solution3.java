package will.zhang.UsingArray.MoveZero283;

/**
 * Leetcode 283
 * Move Zeroes
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 * 原地解决该问题
 * Created by Will.Zhang on 2018/2/27 0027 17:51.
 */
public class Solution3 {

    public void moveZeroes(int[] nums){
        //nums中, [0...k)的元素均为非0元素
        int k = 0;
        //遍历到第i个元素后, 保证[0...i]中所有非0元素, 都按照顺序排列在[0...k)中
        //同时, [k...i]为0
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                //预防整个nums都没有0的时候, 自己和自身进行交换
                if(i != k){
                    swap(nums, k++, i);
                }else{
                    k++;
                }

            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        (new Solution3()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
