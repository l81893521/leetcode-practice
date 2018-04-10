package will.zhang.UsingArray.MinimumWindowSubstring76;

/**
 * Created by Will.Zhang on 2018/4/9 0009 18:47.
 * Leetcode 76号题
 * 给定一个字符串 S 和一个字符串 T, 从S中找出包含T所有字符串的最短子串
 * 时间复杂度要求: O(n)
 * For example:
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * 最小子串为"BANC"
 * 注意:
 * 如果S中没有包含T所有字符的子串, 返回""
 * 假设S中最多只有一个子串包含T的所有字符
 */
public class Solution {
    public String minWindow(String s, String t) {
        if(s.equals("") || s == null || t.equals("") || t == null) return "";

        //记录子串长度
        int minLength = Integer.MAX_VALUE;
        //记录子串的位置
        int[] minIndex = new int[2];

        int[] freq = new int[256];
        //把给定的字符串t每一个字符的ascii放进freq
        for (char c : t.toCharArray()) {
            freq[c] ++;
        }

        char[] c = s.toCharArray();
        //定义时间窗口和计数器
        int l = 0, r = 0, count = t.length();
        while(l <= c.length){
            if(freq[c[r]] > 0){
                count--;
            }
            freq[c[r]] --;
            r++;
            //已经找到子串
            if(count == 0){
                if(r - l < minLength){
                    minLength = r - l;
                    minIndex[0] = l;
                    minIndex[1] = r;
                }
            }
            //如果已经找到子串(非最短)或者时间窗口左边已经触碰到数组的末尾
            //那么时间窗口左边开始往右收缩
            while((count == 0 || r == c.length - 1) && ){
                if(freq[c[l]] >= 0){
                    count++;
                }
                freq[c[l]] ++;
                l++;
            }
        }

        if(minLength != Integer.MAX_VALUE){
            return s.substring(l, r-1);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ABBBBBBBCABC","ABC"));
    }
}
