package com.kevin.algorithm.homework4;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 * 输入:
 * [
 *  ['1','1','1','1','0'],
 *  ['1','1','0','1','0'],
 *  ['1','1','0','0','0'],
 *  ['0','0','0','0','0']
 * ]
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * [
 *  ['1','1','0','0','0'],
 *  ['1','1','0','0','0'],
 *  ['0','0','1','0','0'],
 *  ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * Author Kevin.Huang
 * Date 2020/7/19
 * Time 22:44
 */
public class NumIslandsSolution {

    /**
     * 思路：深度优先。
     * 迭代二维数组，遇到陆地，深度优先将其周围的陆地用0淹没。
     *
     * @param grid 二维数组
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        int isLandNum = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return isLandNum;
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                // 遇到陆地，使用水淹没其和其周围陆地
                if ('1' == grid[r][c]) {
                    isLandNum ++;
                    dfs(r,c,grid);
                }
            }
        }
        return isLandNum;
    }

    private void dfs(int row, int cell, char[][] grid){
        if (row < 0 || cell < 0 || row >= grid.length || cell >= grid[0].length || '0' == grid[row][cell]) {
            return;
        }

        grid[row][cell] = '0';

        dfs(row, cell - 1, grid);
        dfs(row, cell + 1, grid);
        dfs(row - 1, cell, grid);
        dfs(row + 1, cell, grid);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','1'},
                {'1','1','0','1'},
                {'1','0','1','1'}
        };
        System.out.println(new NumIslandsSolution().numIslands(grid));
    }

}
