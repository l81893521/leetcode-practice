package will.zhang.UsingMap.NumberOfBoomerages447;

import java.util.HashMap;
import java.util.Map;

/**
  * @author will.zjw
  * @date 2019-11-13 10:58
  */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;

        for (int i = 0; i < points.length; i++) {

            //记录所有坐标点距离i的距离 key = 距离, value = 坐标数量
            Map<Integer, Integer> record = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis = dis(points[i], points[j]);
                    record.put(dis, record.getOrDefault(dis, 0) + 1);
                }
            }

            //结果累加
            for (Integer integer : record.values()) {
                res += integer * (integer - 1);
            }
        }

        return res;
    }

    /**
     * 计算两点之间的距离
     * @param pa
     * @param pb
     * @return
     */
    private int dis(int[] pa, int[] pb){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][]{
            {0, 0},
            {1, 0},
            {2, 0}
        };
        System.out.println(solution.numberOfBoomerangs(points));
    }
}
