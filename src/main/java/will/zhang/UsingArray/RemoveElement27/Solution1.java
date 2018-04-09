package will.zhang.UsingArray.RemoveElement27;

/**
 * Created by Will.Zhang on 2018/3/15 0015 14:34.
 * Leetcode 27号题目
 * 给定一个数组和值, 删除数组中等于该值的所有元素, 并返回新数组的长度
 * 空间复杂度要求 : O(1)
 * 元素的顺序可以发生改变
 * Example :
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution1 {

    public int removeElement(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int target = 3;
        int[] arr = {3, 2, 2, 3};

        int length = new Solution1().removeElement(arr, target);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("length:" + length);
    }
}
