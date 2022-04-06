package will.zhang.UsingArray.RangeSumQuery2dImmutable304;

/**
 * @author: jiawei.zhang
 * @date: 2022/4/2
 */
public class NumMatrix {

    // 定义：presum[i][j]记录matrix 0, 0, i-1, j-1的和
    private int[][] presum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return;
        }
        int columns = matrix[0].length;
        if (columns == 0) {
            return;
        }

        //记录i, j到0, 0的前缀和
        presum = new int[rows + 1][columns + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j<= columns; j++) {
                presum[i][j] = presum[i-1][j] + presum[i][j-1] + matrix[i-1][j-1] - presum[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] - presum[row1][col2 + 1] + presum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix matrix = new NumMatrix(array);
        System.out.println(matrix.sumRegion(2,1,4,3));

        array = new int[][]{{-4, -5}};
        matrix = new NumMatrix(array);
        System.out.println(matrix.sumRegion(0, 0, 0, 0));
    }
}
