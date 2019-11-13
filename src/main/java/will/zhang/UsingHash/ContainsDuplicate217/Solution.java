package will.zhang.UsingHash.ContainsDuplicate217;

import java.util.HashSet;
import java.util.Set;

/**
  * @author will.zjw
  * @date 2019-11-13 14:45
  */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> record = new HashSet<>();

        for (int num : nums) {
            if (!record.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(s.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
