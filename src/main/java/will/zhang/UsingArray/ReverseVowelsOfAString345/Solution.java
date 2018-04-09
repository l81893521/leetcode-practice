package will.zhang.UsingArray.ReverseVowelsOfAString345;

/**
 * Created by Will.Zhang on 2018/4/9 0009 14:43.
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        /*
        使用对撞指针的思想
        在数组的两侧分别定义l 和 r
        两个指针不断往中间移动, 遇到原音字符就交换字符
         */
        int l = 0, r = c.length - 1;
        while(l < r){
            if(!isVowels(c[l])){
                l++;
                continue;
            }
            if(!isVowels(c[r])){
                r--;
                continue;
            }
            char temp = c[l];
            c[l] = c[r];
            c[r] = temp;
            l++;
            r--;
        }
        return new String(c);
    }

    /**
     * 判断是否为原音字母(a e i o u)
     * @param s
     */
    private boolean isVowels(char s){
        return s == 65 || s == 97 ||
                s == 69 || s == 101 ||
                s == 73 || s == 105 ||
                s == 79 || s == 111 ||
                s == 85 || s == 117;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}
