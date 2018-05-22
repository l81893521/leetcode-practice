package will.zhang.UsingSegmentTree.RangeSumQueryMutable307;

/**
 * LeetCode 307. 区域和检索 - 数组可修改
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以认为调用 update 函数和 sumRange 函数的次数是相等的。
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if(nums.length != 0){
            Integer[] numbers = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numbers[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(numbers, (a, b) -> a + b);
        }

    }

    public void update(int i, int val) {
        if(segmentTree == null){
            throw new IllegalArgumentException("SegmentTree is null");
        }
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        if(segmentTree == null){
            throw new IllegalArgumentException("SegmentTree is null");
        }
        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 7, 2, 0};
        NumArray numArray = new NumArray(nums);
        numArray.update(4, 6);
        numArray.update(0, 2);
        numArray.update(0, 9);
        //System.out.println(numArray.sumRange(4, 4));
        numArray.update(3, 8);
        //System.out.println(numArray.sumRange(0, 4));
        numArray.update(4, 1);
        System.out.println(numArray.sumRange(0, 3));
        //System.out.println(numArray.sumRange(0, 4));
        numArray.update(0, 4);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
