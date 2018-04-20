package will.zhang.UsingHashTable.SortCharactersByFrequency451;


import java.util.*;

/**
 * @Author will
 * @Date 2018/4/13 0013 下午 6:01
 * 给定一个字符串, 根据字符出现的频率倒叙排列重组字符串
 * Example
 * Input: "tree" Output: "eert"
 *
 * Input: "cccaaa" Output: "cccaaa"
 *
 * Input: "Aabb"  Output: "bbAa"
 *
 * 注意
 * 对于出现频次相同的字母,没有顺序要求
 **/
public class Solution {

    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";

        //freq下标对应每一个字符的ascii编码, 值对应出现的频次
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if(freqMap.containsKey(c)){
                freqMap.put(c, freqMap.get(c) + 1);
            }else{
                freqMap.put(c, 1);
            }
        }

        //使用优先队列, 并按照倒叙初始化
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            };
        });
        //按照key=字符 value=出现次数放进优先队列
        priorityQueue.addAll(freqMap.entrySet());

        //遍历优先队列 重新构造出新的字符串
        StringBuilder stringBuilder = new StringBuilder();


        //循环取出堆顶元素(priorityQueue其实是一个堆...)
        while (!priorityQueue.isEmpty()){
            Map.Entry<Character, Integer> stackTop = priorityQueue.poll();
            for (Integer i = 0; i < stackTop.getValue(); i++) {
                stringBuilder.append(stackTop.getKey());
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("raaeaedere"));
    }
}
