package will.zhang.UsingArray.FourSum18;

import java.util.*;

/**
 * @Author will
 * @Date 2018/4/18 0018 下午 5:15
 * Leetcode 18号题
 * 给定一个整形数组nums, 以及目标target, 找出数组里4个元素相加等于target的所有四元组组合
 * 注意
 * 返回结果不能存在一样的四元组
 * Example
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 **/
public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            //预防重复
            if (i > 0 && z == nums[i - 1])
                continue;
            //z太小
            if (z + 3 * max < target)
                continue;
            //z太大
            if (4 * z > target)
                break;
            //命中
            if (4 * z == target) {
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }
            //找到有效的z, 继续在nums[i+1...len-1]寻找后续三位数
            //target为target - z
            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * 寻找所有的三元组+z1等于target
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            //预防重复
            if (i > low && z == nums[i - 1])
                continue;
            //z太小
            if (z + 2 * max < target)
                continue;
            //z太大
            if (3 * z > target)
                break;
            //命中
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }
            //找到有效的z, 继续在nums[i+1...high]之间寻找后续两位数
            //target为target - z
            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        //定义时间窗口左边界为low, 右边界为high
        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            //找到target
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                //不处理重复元素, 预防重复组合
                x = nums[i];
                while (++i < j && x == nums[i])
                    ;
                //不处理重复元素, 预防重复组合
                x = nums[j];
                while (i < --j && x == nums[j])
                    ;
            }
            if (sum < target)
                //时间窗口往右移动
                i++;
            if (sum > target)
                //时间窗口往左移动
                j--;
        }
        return;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(5, Arrays.asList(-2,0,0,3,3,-1));
        map.put(28, Arrays.asList(-7,-5,0,7,1,1,-10,-2,7,7,-2,-6,0,-10,-5,7,-8,5));
        for (Map.Entry<Integer, List<Integer>> t : map.entrySet()) {
            int[] value = new int[t.getValue().size()];
            for (int i = 0; i < t.getValue().size(); i++) {
                value[i] = t.getValue().get(i);
            }
            System.out.println(Arrays.toString(new Solution2().fourSum(value, t.getKey()). toArray()));
        }

    }
}
