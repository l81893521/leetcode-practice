package will.zhang.UsingArray.KthLargetElementInAnArray215;

/**
 * Created by Will.Zhang on 2018/4/4 0004 17:49.
 * LeetCode 215号题
 * 给定一个非有序数组, 找出第k大的元素
 * Example:
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return slove(nums, 0, nums.length-1, k-1);
    }

    private int slove(int[] nums, int l, int r, int k){
        if(k < 0) return 0;
        if(l == r) return nums[l];

        int target = partition(nums, l, r);

        //nums的左半部分 > target, 右半部分 < target
        if(target > k){
            //从左半部分继续寻找
            return slove(nums, l, target-1, k);
        }else if(target < k){
            //从右半部分继续寻找
            return slove(nums, target+1, r, k);
        }else{//p==k
            return nums[target];
        }
    }

    /**
     * 对arr[l...r]进行partition操作
     * 使得
     * arr[l...target-1] > target > arr[target+1...r]
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] nums, int l, int r){

        swap(nums, l, (int) (Math.random() * (r - l + 1) + l));

        int target = nums[l];

        //arr[l+1...j] > target;
        //arr[j+1...i) < target
        int j = l;

        for(int i = l+1; i <= r; i++){
            if(nums[i] > target){
                swap(nums, ++j, i);
            }
        }

        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};

        int result = new Solution().findKthLargest(nums, 2);

        System.out.println(result);
    }
}
