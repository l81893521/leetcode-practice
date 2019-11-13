package will.zhang.UsingMap.GroupAnagrams49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @author will.zjw
  * @date 2019-11-12 19:32
  */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ans = new HashMap<>();

        int[] count = new int[26];

        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }
            String key = stringBuilder.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> results = s.groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"});
        for (List<String> result : results) {
            System.out.println(result);
        }
    }
}
