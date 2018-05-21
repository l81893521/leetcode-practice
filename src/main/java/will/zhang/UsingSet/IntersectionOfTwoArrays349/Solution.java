package will.zhang.UsingSet.IntersectionOfTwoArrays349;

import java.util.*;

/**
 * @Author will
 * @Date 2018/4/12 0012 下午 10:57
 *
 * Leetcode 349号题
 * 给定2个数组， 找出它们的共同元素
 * Example：
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * 注意：
 * 在返回结果中，不能出现相同元素
 * 返回结果顺序没有特别要求
 **/
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        //把nums1所有元素都放进set集合中
        for (int i : nums1) {
            set.add(i);
        }

        //把公共元素放进result中
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int[] resultArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2 ,2})));
    }


}
