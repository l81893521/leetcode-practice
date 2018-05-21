package will.zhang.UsingPriorityQueue.TopKFrequentElements347;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 例如，
 *
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * 注意：
 *
 * 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        //把给定的数组nums按照数字key,出现频率value放进map中
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        //使用java的优先队列(最小堆)
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt(map::get)
        );
        for (Integer num : map.keySet()) {
            //如果堆还没达到k,则直接放入盏
            if(pq.size() < k){
                pq.add(num);
            }else{
                //如果当前数字的频率大于堆顶的元素
                if(map.get(num) > (map.get(pq.peek()))){
                    //移除堆顶元素
                    pq.remove();
                    //放进最新元素
                    pq.add(num);
                }
            }
        }

        //这时候优先队列里面保存的已经是出现频次最高的k个元素, 保存到list返回即可
        LinkedList<Integer> list = new LinkedList<>();
        while(!pq.isEmpty()){
            list.add(pq.remove());
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1, 0};
        System.out.println(new Solution().topKFrequent(nums, 1));
    }
}
