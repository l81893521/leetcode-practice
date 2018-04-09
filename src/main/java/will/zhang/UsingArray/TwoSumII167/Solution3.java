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
public class Solution3 {
    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        /*
        使用对撞指针的思路
        在数组的两侧分别定义l 和 r
        两个指针不断往中间移动, 直到找出target
         */
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1, r+1};
            }else if(numbers[l] + numbers[r] < target){
                l ++;
            }else{
                r --;
            }
        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) throws Exception {
        int arr[] = {1,2,3,4,4,9,56,90};
        int target = 8;
        int[] result = new Solution3().twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
