package will.zhang.UsingHash.ContainsDuplicateII219;

import java.util.HashSet;

/**
  * @author will.zjw
  * @date 2019-11-13 14:18
  */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);

            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
