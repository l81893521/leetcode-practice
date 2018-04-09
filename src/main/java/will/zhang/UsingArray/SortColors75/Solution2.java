package will.zhang.UsingArray.SortColors75;

/**
 * Created by Will.Zhang on 2018/4/4 0004 15:15.
 * LeetCode 75号题
 * 给定一个无序数组, 该数组只只包含 0, 1 和 2, 将该数组排序
 */
class Solution2 {


    /**
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     * 只遍历了数组一遍
     * @param nums
     */
    public void sortColors(int[] nums) {

        int zero = -1;  //[0...zero] = 0
        int two = nums.length;    //[two...n-1] = 2

        /*
        使用三路快排的思想
        使得
        [0...zero] = 0
        [zero+1...i-1] = 1
        [two...n-1] = 2
         */
        for (int i = 0; i < two;) {
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                swap(nums, --two, i);
            }else{
                assert nums[i] == 0;
                swap(nums, ++zero, i++);
            }
        }
    }

    /**
     * 元素交换
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 0 , 1, 0};

        new Solution2().sortColors(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
