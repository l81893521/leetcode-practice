package will.zhang.UsingArray.FindAllAnagramsInAString438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Will.Zhang on 2018/4/9 0009 16:34.
 * Leetcode 438号题
 * 给定一个字符串 s 和一个非空字符串 p, 找出所有属于p的anagrams的起始索引(anagrams表示包含p的全部字符,顺序不要求一致)
 * 假设字符串 s 和 p 只包含小写字母
 * 返回值的顺序不作限制
 * Example
 * Input
 * s: "cbaebabacd" p: "abc"
 * Output
 * [0, 6] 索引从0开始, cba是abc的anagram, 索引从6开始bac是abc的anagram
 *
 *
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        //用于记录字符串p中每一个字符的ascii
        int[] freq = new int[256];
        for (char c : p.toCharArray()) {
            freq[c]++;
        }
        char[] c = s.toCharArray();
        //初始化滑动窗口
        //count是用于计数
        int l = 0, r = 0, count = p.length();
        /*
        使用时间窗口的思想
        如果两个char数组返回true, 则记录下当前l的索引
         */
        while (r < s.length()) {
            if(freq[c[r]] > 0){
                count--;
            }
            freq[c[r]]--;
            r++;

            if(count == 0){
                result.add(l);
            }

            if(r - l == p.length()){
                if(freq[c[l]] >= 0){
                    count++;
                }
                freq[c[l]]++;
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findAnagrams("abcdefge", "efg").toArray()));
    }

}
