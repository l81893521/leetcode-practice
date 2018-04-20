package will.zhang.UsingHashTable.ValidAnagram242;

/**
 * @Author will
 * @Date 2018/4/13 0013 下午 3:27
 *
 * 给定两个字符串s和t, 判断t是否是s的anagram
 * for example:
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * 注意:
 * 你可以假设输入的字符都为小写字母
 **/
public class Solution {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;

        //记录字符串s每一个字符在对应的ascii位置对应的频次
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c] ++;
        }

        //循环字符串t每一个字符串,然后如果存在于freq,则计数器-1
        int count = t.length();
        for (char c : t.toCharArray()) {
            if(freq[c] > 0){
                freq[c] --;
                count--;
            }
        }

        if(count == 0){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("abcd", "cba"));
    }
}
