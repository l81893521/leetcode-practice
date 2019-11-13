package will.zhang.UsingHash.HappyNumber202;

/**
 * @Author will
 * @Date 2018/4/13 0013 下午 3:42
 * Leetcode 202号题
 *
 * 判断一个数字是否为happy number
 * Happy number是指, 一个数, 将其替换为个位数字的平方和, 重复这个过程, 如果最后能得到1, 则为happy
 * 如果这个过程陷入了不包含1的过程, 则不是happy number
 * Example:
 * 19是happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 **/
public class Solution {


    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = next(slow);
            //如果存在相同元素,因为fast计算两次的关系,会慢慢追上slow,直到两个元素一致
            fast = next(next(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    public int next(int n) {
        int result = 0;
        while (n > 0) {
            int remainder = n % 10;
            result += remainder * remainder;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(567));
    }
}
