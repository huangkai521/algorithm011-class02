package com.kevin.algorithm.homework4;

/**
 *  https://leetcode-cn.com/problems/search-a-2d-matrix/
 *  74. 搜索二维矩阵
 *  编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *  每行中的整数从左到右按升序排列。
 *  每行的第一个整数大于前一行的最后一个整数。
 *
 *  示例 1:
 *  输入:
 *  matrix = [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 *  ]
 *  target = 3
 *  输出: true
 *
 *  示例 2:
 *  输入:
 *  matrix = [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 *  ]
 *  target = 13
 *  输出: false
 *
 * Author Kevin.Huang
 * Date 2020/7/19
 * Time 21:08
 */
public class SearchMatrixSolution {

    /**
     * 思路：
     * 每行每列都是有规律的。
     * 可以从左下角开始迭代，大于目标值就向上一行，小于目标值就向右一列。直至遍历完成。
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 二维矩阵是否存在目标值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowIndex = matrix.length - 1;
        int cellIndex = 0;
        while (rowIndex >= 0 && cellIndex < matrix[0].length) {
            int curr = matrix[rowIndex][cellIndex];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                rowIndex --;
            } else {
                cellIndex ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(new SearchMatrixSolution().searchMatrix(matrix, 4));
    }
}
