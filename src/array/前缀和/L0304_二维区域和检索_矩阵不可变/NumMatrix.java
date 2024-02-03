package array.前缀和.L0304_二维区域和检索_矩阵不可变;

/**
 * @author xufan
 * @since 2024/02/03 22:39
 */

class NumMatrix {

    //preSum[i][j] 的值为[0][0] 到[i][j]之间的数字和
    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preSum = new int[m+1][n+1];
        preSum[0][0] = matrix[0][0];
        //相当于在矩阵的最上和最右多加一层
        for(int i = 1 ; i <= m; i++){ //注意等号
            for(int j = 1 ; j <= n ; j++){ //注意等号
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1]; //注意是matrix[i-1][j-1]
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //[row1,col1]~[row2,col2]之间的和 = preSum[row2,col2]
        //                                  - preSum[row1-1, col2]
        //                                  - preSum[row2, col1-1]
        //                                  + preSum[row1-1, col1-1]
        //由于多加了一层，所以下标应该都变大1，才是正确的计算坐标
        row1++; row2++; col1++; col2++;
        return preSum[row2][col2]
                - preSum[row1-1][col2]
                - preSum[row2][col1-1]
                + preSum[row1-1][col1-1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */