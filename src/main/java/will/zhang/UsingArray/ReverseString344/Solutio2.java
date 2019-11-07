package will.zhang.UsingArray.ReverseString344;


/**
 * Created by Will.Zhang on 2018/4/9 0009 14:29.
 * Leetcode 344号题目
 * 反转字符串
 * Example:
 * Given s = "hello", return "olleh".
 */
public class Solutio2 {

    public void reverseString(char[] s) {
        /*
        使用对撞指针的思想
        在数组的两侧分别定义i 和 j
        两个指针不断往中间移动, 不断交换字符
         */
        int i = 0, j = s.length - 1;

        while(i <= j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] c = "hello".toCharArray();
        new Solutio2().reverseString(c);
        System.out.println(new String(c));
    }
}
