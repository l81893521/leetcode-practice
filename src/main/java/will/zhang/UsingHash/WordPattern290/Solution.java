package will.zhang.UsingHash.WordPattern290;

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
public class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;

        Map<Character, String> dict = new HashMap<>();

        char[] c = pattern.toCharArray();
        for (int i = 0; i < c.length; i++) {
            //如果已经存在于字典中
            if(dict.containsKey(c[i])){
                //如果存在 判断字典内容是否一致
                if(!dict.get(c[i]).equals(words[i])){
                    return false;
                }
            }else{
                //没有找到对应的key, 但是找到了一样的value
                if(dict.containsValue(words[i])){
                    return false;
                }
            }
            dict.put(c[i], words[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));
    }
}
