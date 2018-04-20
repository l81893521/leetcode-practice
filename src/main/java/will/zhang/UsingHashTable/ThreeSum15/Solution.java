package will.zhang.UsingHashTable.ThreeSum15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author will
 * @Date 2018/4/18 0018 下午 4:09
 * 给定一个数值类型数组, 找出所有a + b + c等于0的所有三元组
 * 注意
 * 返回结果不能出现重复的三元组
 * Example
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 **/
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            //经过排序后, nums[i] > 0 则可以退出, 因为已经无任何组合
            if(nums[i] > 0) break;
            //i > 0 && nums[i] != nums[i - 1] 经过排序后, 一样的元素就不用处理了, 因为前一次已经把该元素所有的组合找到了
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                //定义两个指针(指针对撞), 分别为i+1和length-1, 两个指针不断往对方移动
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        //nums[lo] == nums[lo + 1] 不用处理, 已经存在该组合
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo ++;
                        //nums[hi] == nums[hi - 1]) 不用处理, 已经存在该组合
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi --;
                        lo++;
                        hi--;
                    }else if(nums[lo] + nums[hi] < sum){
                        //lo往前移动
                        lo++;
                    }else{
                        //hi往后移动
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toArray()));
    }
}
