package will.zhang.UsingArray.TwoSumII167;

import java.util.Arrays;

/**
 * Created by Will.Zhang on 2018/4/8 0008 18:24.
 * LeetCode 167号题
 * 给定一个升序的有序数组, 找出2个元素相加之和为给定的目标值target, 返回该2个元素的下标值
 * 注意:
 * index1必须少于index2
 * 下标从1开始
 * 不能使用相同元素2次
 * 假设题目一定有解,不会出现无解的情况
 */
public class Solution {
    /**
     * 暴露解法
     * 2层循环
     * 时间复杂度: O(n^2)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i != j && numbers[i] + numbers[j] == target){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;
        int[] result = new Solution().twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
