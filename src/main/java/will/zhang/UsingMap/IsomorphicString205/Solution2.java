package will.zhang.UsingMap.IsomorphicString205;

/**
 * @Author will
 * @Date 2018/4/13 0013 下午 5:32
 * 给定字符串s和t, 判断他们是否同构
 * Example
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 **/
public class Solution2 {

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        //freq用于保存字符对应的ascii出现的频次
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if(sFreq[s.charAt(i)] != tFreq[t.charAt(i)]) return false;
            sFreq[s.charAt(i)] = i + 1;
            tFreq[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String aWord = "aba";
        String bWord = "baa";
        System.out.println(new Solution2().isIsomorphic(aWord, bWord));
    }
}
