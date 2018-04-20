package will.zhang.UsingHashTable.FourSum18;

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
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            //i > 0 && nums[i] != nums[i - 1] 经过排序后, 一样的元素就不用处理了, 因为前一次已经把该元素所有的组合找到了
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                //定义一个固定元素和两个指针(指针对撞)
                //sum为nums[fixedIndex] + nums[low] + nums[high]的结果
                int fixedIndex = i + 1, low = i + 2, high = nums.length - 1, sum = target - nums[i];
                while(low < high){
                    if(nums[fixedIndex] + nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[fixedIndex], nums[low], nums[high]));
                        //nums[low] == nums[low + 1] 不用处理, 已经存在该组合, low往前移动, 直到遇到不一样元素
                        //low - fixedIndex nums[low]允许和nums[fixedIndex]一致, 所以可以不比较
                        while(low < high && nums[low] == nums[low -1] && low - fixedIndex > 1) low ++;
                        //nums[gh] == nums[high - 1]) 不用处理, 已经存在该组合, high往后移动, 直到遇到不一样元素
                        while(low < high && nums[high] == nums[high - 1]) high --;
                        //low往前移动, high往后移动
                        low++;
                        high--;
                    }else if(nums[fixedIndex] + nums[low] + nums[high] < sum){
                        //low指针往前移动
                        low++;
                    }else{
                        //high指针往后移动
                        high--;
                    }
                    //固定指针前进一部
                    //重新定义对撞指针
                    if(low >= high && fixedIndex < nums.length - 3){
                        do{
                            fixedIndex ++;
                            low = fixedIndex + 1;
                            high = nums.length - 1;
                            if(low == high) break;
                        }while (nums[fixedIndex] == nums[fixedIndex-1]);
                    }
                }
            }
        }
        return res;
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
            System.out.println(Arrays.toString(new Solution().fourSum(value, t.getKey()). toArray()));
        }

    }
}
