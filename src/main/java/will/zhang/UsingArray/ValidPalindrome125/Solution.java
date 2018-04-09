package will.zhang.UsingArray.ValidPalindrome125;

/**
 * Created by Will.Zhang on 2018/4/9 0009 11:54.
 * LeetCode 125号题
 * 给定一个字符串, 判断是否是回文串, 只看其中的字符和数字, 并且忽略大小写
 * For example:
 * "A man, a plan, a canal: Panama"这是一个回文串
 * "race a car" 这不是一个回文串
 * 注意:
 * 请把空字符串也当作是回文串
 */
public class Solution {
    public boolean isPalindrome(String s) {
        //空字符串也当作是回文串
        if(s.isEmpty()){
            return true;
        }

        char[] c = s.toLowerCase().toCharArray();
        /*
        使用对撞指针的思路
        在数组的两侧分别定义l 和 r
        两个指针不断往中间移动, 不断判断字符是否一致
         */
        int l = 0, r = c.length -1;
        while(l <= r){
            if(!Character.isLetterOrDigit(c[l])){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(c[r])){
                r--;
                continue;
            }
            if(c[l] != c[r]){
                return false;

            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("a");
        //System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
