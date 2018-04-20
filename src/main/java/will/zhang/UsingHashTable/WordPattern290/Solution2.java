package will.zhang.UsingHashTable.WordPattern290;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author will
 * @Date 2018/4/13 0013 下午 4:21
 * 给定一个模式pattern和一个字符串str, 判断字符串是否符合给定的模式
 * Example
 * 1. pattern = "abba", str = "dog cat cat dog" should return true.
 * 2. pattern = "abba", str = "dog cat cat fish" should return false.
 * 3. pattern = "aaaa", str = "dog cat cat dog" should return false.
 * 4. pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * 注意
 * 你可以假设pattern只包含小写字符, str只包含小写字符并且是用空格分割
 *
 **/
public class Solution2 {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;

        Map dict = new HashMap();

        for (Integer i = 0; i < words.length; i++) {
            if(dict.put(pattern.charAt(i), i) != dict.put(words[i], i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String words = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(new Solution2().wordPattern(pattern, words));
    }
}
