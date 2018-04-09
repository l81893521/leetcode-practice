package will.zhang.UsingArray.MinimumSizeSubarraySum209;

/**
 * Created by Will.Zhang on 2018/4/9 0009 16:00.
 * Leetcode 209号题
 * 给定一个整数数组, 和一个整数 s, 从这个数组中找出最小长度的连续字数组, 该子数组中所有元素的和必须要 大于等于 s
 * 如果无解, 返回0
 * For example
 * given the array [2,3,1,2,4,3] and s = 7
 * the subarray [4,3] has the minimal length under the problem constraint.
 * return 2
 *
 */
public class Solution {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        //nums[l..r]为我们的滑动窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;

        /*
        使用滑动窗口的思路
        如果sum < s 则滑动窗口往右扩大一格
        如果sum > s 则滑动窗口往左缩小一个
        不断得出最小的子数组长度
         */
        while(l < nums.length){
            //r + 1 < nums.length是预防数组越界
            if(r + 1 < nums.length && sum < s){
                sum += nums[++r];
            }else{
                sum -= nums[l++];
            }

            if(sum >= s){
                res = Math.min(res, r-l+1);
            }
        }

        if(res == nums.length + 1){
            return 0;
        }else{
            return res;
        }
    }

    public static void main(String[] args) {
        int minSize = new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        System.out.println(minSize);
    }
}
