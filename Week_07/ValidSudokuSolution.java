package com.kevin.algorithm.homework7;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 * 36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Author Administrator
 * Date 2020/8/29
 * Time 22:25
 */
public class ValidSudokuSolution {
    int L = 9;
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[L][L];
        boolean[][] columns = new boolean[L][L];
        boolean[][] boxes = new boolean[L][L];
        for (int r = 0; r < L; r++) {
            for (int c = 0; c < L; c++) {
                if (board[r][c] != '.') {
                    int value = board[r][c] - '1';// 值为行、列、盒子内的索引
                    int boxIndex = r / 3 * 3 + c / 3;
                    if (rows[r][value] || columns[c][value] || boxes[boxIndex][value]) {
                        return false;
                    }
                    rows[r][value] = true;
                    columns[c][value] = true;
                    boxes[boxIndex][value] = true;
                }
            }
        }
        return true;
    }
}
