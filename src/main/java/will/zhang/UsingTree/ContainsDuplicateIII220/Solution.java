package will.zhang.UsingTree.ContainsDuplicateIII220;

import java.util.TreeSet;

/**
  * @author will.zjw
  * @date 2019-11-13 15:43
  */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long ceil = record.ceiling((long)nums[i] - (long)t);
            if (ceil != null && ceil <= (long)nums[i] + (long)t) {
                return true;
            }

            record.add((long)nums[i]);

            if (record.size() == k + 1) {
                record.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{0,2147483647}, 1, 2147483647));
    }
}
