package will.zhang.UsingHashTable.ThreeSumClosest16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author will
 * @Date 2018/4/19 0019 下午 3:18
 * Leetcode 16号题
 * 给定一个整型数组nums, 和一个整型target
 * 找出数组里三个元素相加的和最接近target
 * 返回相加后的值
 * 注意
 * 你可以假设一定有解
 *
 * Example
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 **/
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) throw new IllegalStateException("the input has no solution");

        Arrays.sort(nums);


        //默认总和
        int sum = Integer.MAX_VALUE;
        int z;
        for (int i = 0; i < nums.length-2; i++) {
            //先固定一个数z, 然后找出另外两个数最接近target - z
            z = nums[i];
            //找出最接近target - z的两个数的总和
            int tempSum = twoSumforThreeSum(nums, i + 1, nums.length - 1, target - z, z);
            //如果差距比原来的小, 则替换
            if(sum == Integer.MAX_VALUE || Math.abs(target - tempSum) < Math.abs(target - sum)){
                sum = tempSum;
            }
        }
        return sum;
    }

    private int twoSumforThreeSum(int[] nums, int low, int high, int target, int z){
        //定义时间窗口
        int i = low, j = high, sum = nums[low] + nums[high];
        while(i < j){
            //找到目标直接退出
            if(nums[i] + nums[j] == target){
                sum = nums[i] + nums[j];
                break;
            }else if(nums[i] + nums[j] < target){
                if(Math.abs(target - (nums[i] + nums[j])) < Math.abs(target - sum)){
                    sum = nums[i] + nums[j];
                }
                //窗口往右收缩
                i++;
            }else{
                if(Math.abs(target - (nums[i] + nums[j])) < Math.abs(target - sum)){
                    sum = nums[i] + nums[j];
                }
                //窗口往左收缩
                j--;
            }
        }

        return sum + z;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
//        map.put(1, Arrays.asList(-1, 2, 1, -4));
//        map.put(5, Arrays.asList(1, 2, 3, 4, 5, 6));
//        map.put(7, Arrays.asList(6, 5, 4, 3, 2, 1));
//        map.put(-5, Arrays.asList(6, 5, 4, 3, 2, 1));
//        map.put(0, Arrays.asList(-1, -2, -3, 1, 2, 3));
//        map.put(4, Arrays.asList(-1, -2, -3, 1, 2, 3));
        map.put(-1, Arrays.asList(1,1,-1,-1,3));
        for (Map.Entry<Integer, List<Integer>> t : map.entrySet()) {
            int[] value = new int[t.getValue().size()];
            for (int i = 0; i < t.getValue().size(); i++) {
                value[i] = t.getValue().get(i);
            }
            System.out.println("target=" + t.getKey() + ", sum=" +new Solution().threeSumClosest(value, t.getKey()));
        }
    }
}
