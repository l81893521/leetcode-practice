package will.zhang.UsingHashTable.IntersectionOfTwoArraysII350;

import java.util.*;

/**
 * @Author will
 * @Date 2018/4/13 0013 下午 2:06
 *
 * Leetcode 350号题目
 * 给定两个数组Nums, 求两个数组的交集
 * Example：
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * 注意：
 * 交集元素可以出现多个相同
 * 返回结果对顺序没有要求
 *
 **/
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> record = new HashMap<>();
        //把nums1中的元素作为Key, 出现频次作为value放进record中
        for (int i = 0; i < nums1.length; i++) {
            record.put(nums1[i], record.get(nums1[i]) == null ? 1 : record.get(nums1[i]) + 1);
        }

        //判断nums2中的元素,如果在record中存在,则保存到list中
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if(record.containsKey(num) && record.get(num) > 0){
                list.add(num);
                record.put(num, record.get(num) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1}, new int[]{1, 1})));
    }
}
