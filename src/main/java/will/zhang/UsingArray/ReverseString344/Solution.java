package will.zhang.UsingArray.ReverseString344;

/**
 * Created by Will.Zhang on 2018/4/9 0009 14:29.
 * Leetcode 344号题目
 * 反转字符串
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Solution {

    /**
     * 将字符串倒序遍历
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] c = new char[s.length()];

        int j = 0;
        for (int i = s.toCharArray().length - 1; i >= 0 ; i--) {

            c[j++] = s.charAt(i);
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("hello"));
    }
}
