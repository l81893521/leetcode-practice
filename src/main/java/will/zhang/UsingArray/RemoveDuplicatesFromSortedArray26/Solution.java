package will.zhang.UsingArray.RemoveDuplicatesFromSortedArray26;

/**
 * Created by Will.Zhang on 2018/3/14 0014 16:54.
 * Leetcode 26号题目
 * 给定一个有序数组, 去除数组中重复的元素, 并且返回非重复元素的长度
 * 空间复杂度要求 : O(1)
 * Example :
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};

        int length = new Solution().removeDuplicates(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("length:" + length);
    }
}
