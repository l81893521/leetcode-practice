package will.zhang.UsingArray.RemoveElement27;

/**
 * Created by Will.Zhang on 2018/2/27 0027 18:26.
 * Leetcode 27号题目
 * 给定一个数组和值, 删除数组中等于该值的所有元素, 并返回新数组的长度
 * 空间复杂度要求 : O(1)
 * 元素的顺序可以发生改变
 * Example :
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        //最后一个非目标元素的下标(也等同于非目标元素的个数)
        int lastNonTargetValueIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val && i != lastNonTargetValueIndex){
                swap(nums, i, lastNonTargetValueIndex++);
            }
        }
        return lastNonTargetValueIndex;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int target = 3;
        int[] arr = {3, 2, 2, 3};
        //int arr[] = {3,3,5};

        int length = new Solution().removeElement(arr, target);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("length:" + length);
    }
}
