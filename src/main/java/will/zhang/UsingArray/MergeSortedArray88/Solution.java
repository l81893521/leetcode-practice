package will.zhang.UsingArray.MergeSortedArray88;

/**
 * Created by Will.Zhang on 2018/4/4 0004 16:06.
 * LeetCode 88号题
 * 给定2个有序数组nums1和nums2, 合并两个数组并且保持有序
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //把数据都填充到nums1中
        for (int i = 0; i < nums2.length; i++) {
            nums1[i+m] = nums2[i];
        }
        /*
        因为nums1[0...m-1]和nums1[m...num1.lenght-1]这两个范围都是有序的
        所以对这两个范围进行归并
         */
        merge(nums1, 0, m-1, nums1.length-1);
    }

    /**
     * 使用归并排序的思想
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private void merge(int[] nums, int l, int mid, int r){
        //将数组的值赋给临时数组aux
        int aux[] = new int[r-l+1];
        for(int i = l; i <= r; i++){
            aux[i-l] = nums[i];
        }

        int i = l;
        int j = mid+1;

        //对数组进行归并排序
        for(int k = l; k <= r; k++){
            // 比较临时数组
            if(i > mid){    // 左半部分的元素已经全部处理完毕
                nums[k] = aux[j-l];
                j++;
            }else if(j > r){    //右半部分的元素已经全部处理完毕
                nums[k] = aux[i-l];
                i++;
            }else if(aux[i-l] < aux[j-l]){  // 左半部分所指的元素 < 右半部分所指的元素
                nums[k] = aux[i-l];
                i++;
            }else{  // 左半部分所指的元素 > 右半部分所指的元素
                nums[k] = aux[j-l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 5, 6};

        new Solution().merge(nums1, 1, nums2 ,5);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
