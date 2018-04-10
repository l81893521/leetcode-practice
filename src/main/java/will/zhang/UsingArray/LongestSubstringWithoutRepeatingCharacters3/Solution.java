package will.zhang.UsingArray.LongestSubstringWithoutRepeatingCharacters3;

/**
 * Created by Will.Zhang on 2018/4/9 0009 16:14.
 * Leetcode 3号题
 * 给定一个字符串, 找出最长并且没有重复字符的长度
 * Examples :
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //ascii表,该字符是否已经存在于当前滑动窗口
        int[] freq = new int[256];

        char[] c = s.toCharArray();
        //滑动窗口为s[l...r]
        int l = 0, r = -1;

        int res = 0;

        /*
        使用滑动窗口的思想
        如果 freq[c[r+1]] == 0 那么 滑动窗口往右延长, 同时把freq[c[r]]也++, 表示该字符已经在滑动窗口中
        如果 freq[c[r+1]] != 0 那么代表该字符已经出现在滑动窗口中了
        同时滑动窗口往左缩小, 直到滑动窗口不存在该重复的字符
         */
        while(l < c.length){
            //r + 1 < c.length是预防越界
            if(r + 1 < c.length && freq[c[r+1]] == 0){
                freq[c[++r]] ++;
            }else{
                freq[c[l++]] --;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcdefga"));
    }
}
