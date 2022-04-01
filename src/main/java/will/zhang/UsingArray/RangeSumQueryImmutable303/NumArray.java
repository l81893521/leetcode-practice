package will.zhang.UsingArray.RangeSumQueryImmutable303;

public class NumArray {

    //sum[i] = nums[0...i-1]的和
    private int[] sum;
    public NumArray(int[] nums) {
        //需要比nums长1, 因为索引0的位置不使用
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 5, 6, 7});
        System.out.println(numArray.sumRange(0, 2));
    }
}
