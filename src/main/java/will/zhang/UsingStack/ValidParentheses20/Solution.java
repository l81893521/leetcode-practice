package will.zhang.UsingStack.ValidParentheses20;

import java.util.Stack;

/**
 * @Author will
 * @Date 2018/5/9 0009 下午 3:54
 * Leetcode 20号题
 * 给定一个字符串只包含'(', ')', '{', '}', '[' 和 ']',检查该字符串是否合法
 * 合法的定义:
 * 括号必须按顺序开启和关闭
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 **/
public class Solution {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //把字符串中的所有左括号全部放入盏
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;

                Character top = stack.pop();

                if(top == '(' && c != ')') return false;
                else if(top == '{' && c != '}') return false;
                else if(top == '[' && c != ']') return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("() : " + new Solution().isValid("()"));
        System.out.println("()[]{} : " + new Solution().isValid("()[]{}"));
        System.out.println("(] : " + new Solution().isValid("(]"));
        System.out.println("([)] : " + new Solution().isValid("([)]"));
        System.out.println("{[]} : " + new Solution().isValid("{[]}"));
    }
}
