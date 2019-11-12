package will.zhang.UsingMap.FourSumII454;

import java.util.HashMap;
import java.util.Map;

/**
  * @author will.zjw
  * @date 2019-11-12 19:07
  */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int res = 0;

        //c + d的和, key = 和, value = 出现频率
        Map<Integer, Integer> cdSum = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                cdSum.put(C[i] + D[j], cdSum.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        //结合a和b两个数组, 找出出现频次
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                //sum的负值就是要找的值
                res += cdSum.getOrDefault(-sum, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
