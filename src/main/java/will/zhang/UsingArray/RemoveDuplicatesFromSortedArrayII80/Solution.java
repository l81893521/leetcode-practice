package will.zhang.UsingArray.RemoveDuplicatesFromSortedArrayII80;

/**
 * Created by Will.Zhang on 2018/3/14 0014 16:54.
 * Leetcode 80号题目
 * 给定一个有序数组, 每个重复元素最多可以存在2次, 并把其他重复元素移除 , 并且返回非重复元素的长度
 * Example :
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        //最终返回的数组长度
        int i = 0;
        //重复元素存在的次数
        int existTimes = 1;
        for (int j = 1; j < nums.length; j++) {
            //num[j]和[i]不一样
            if(nums[j] != nums[i]){
                nums[++i] = nums[j];
                existTimes = 1;
            }else{  //num[j]和num[i]一样
                if(existTimes == 2) continue;

                existTimes++;
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 3, 3};

        int length = new Solution().removeDuplicates(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("length:" + length);
    }
}
