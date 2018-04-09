package will.zhang.UsingArray.SortColors75;

/**
 * Created by Will.Zhang on 2018/4/4 0004 15:15.
 * LeetCode 75号题
 * 给定一个无序数组, 该数组只只包含 0, 1 和 2, 将该数组排序
 */
class Solution {


    /**
     * 使用计数排序法
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     * @param nums
     */
    public void sortColors(int[] nums) {

        //存放0, 1, 2 三个元素的频率
        int[] count = new int[3];
        //计算出0, 1, 2分别有多少个
        for (int i = 0; i < nums.length; i++) {
            assert nums[i] >= 0 && nums[i] <=2;
            count[nums[i]] ++;
        }

        //根据跟算出来的个数, 依次重新放入数组
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 0 , 1, 0};

        new Solution().sortColors(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
