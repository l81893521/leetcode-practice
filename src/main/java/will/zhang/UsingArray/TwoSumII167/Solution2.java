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
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            //只要从arr[0...arr.length]找到target - numbers[i]的值,就代表解
            int index2 = binarySearch(numbers, 0, numbers.length-1, target-numbers[i], i);
            // i!=index(不能使用相同元素2次)
            if(index2 != -1){
                //题目要求下标从1开始
                return new int[]{i+1, index2+1};
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 从arr[l...r]找出值p
     * @param arr
     * @param l
     * @param r
     * @param i 循环索引值, 仅用于判断
     * @return
     */
    private int binarySearch(int[] arr, int l, int r, int p, int i){
        if(l > r) return -1;

        int mid = l + (r - l) / 2;

        if(arr[mid] == p && mid != i){
            return mid;
        }else if(arr[mid] < p || mid == i){
            //如果arr[mid] < p, 那么继续从右半部分寻找
            return binarySearch(arr, mid+1, r, p, i);
        }else{
            //arr[mid] > p
            return binarySearch(arr, l, mid-1, p, i);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,9,56,90};
        int target = 8;
        int[] result = new Solution2().twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
