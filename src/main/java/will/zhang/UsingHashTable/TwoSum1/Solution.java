package will.zhang.UsingHashTable.TwoSum1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author will
 * @Date 2018/4/18 0018 下午 3:38
 * Leetcode 1号题
 * 给定一个数组, 和一个target, 寻找数组中2个元素的和等于target, 并返回元素下标
 * 你可以假设一定有解
 * Example
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        //查找表key = number, value = 该number在数组中的下标
        Map<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //计算出需要找到什么值
            int c = target - nums[i];
            //先查找查找表中是否存在
            if(record.containsKey(c)){
                return new int[]{record.get(c), i};
            }
            //先查找查找表中的元素, 找不到再将目前元素放进查找表
            //因为数组中有可能会出现相同元素, 而元素的值作为key, 放进hashMap的话就会出现覆盖
            //同时我们只需要返回2个索引
            //那么就可以先查找, 再放进查找表, 那么就算覆盖也不会出现问题
            record.put(nums[i], i);
        }

        throw new IllegalStateException("the input has no solution");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
