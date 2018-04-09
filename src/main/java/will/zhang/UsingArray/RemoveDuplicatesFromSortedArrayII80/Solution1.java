package will.zhang.UsingArray.RemoveDuplicatesFromSortedArrayII80;

/**
 * Created by Will.Zhang on 2018/3/14 0014 16:54.
 * Leetcode 80号题目
 * 给定一个有序数组, 每个重复元素最多可以存在2次, 并把其他重复元素移除 , 并且返回非重复元素的长度
 * Example :
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        //允许元素重复的个数
        int k = 2;

        if(nums.length < k) return nums.length;

        int i,j;
        for (i=k,j=k; i < nums.length; i++) {
            if(nums[j-k] != nums[i]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 3, 3};

        int length = new Solution1().removeDuplicates(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("length:" + length);
    }
}
