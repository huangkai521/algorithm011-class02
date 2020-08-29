学习笔记
###  一、高级动态规划
#### 1.动态规划和递归、分治的区别
- 共性：重复子问题
- 差异：动态规划具有最优子结构，中途可以淘汰次优解

#### 2.复杂度来源
- 状态拥有更多维度（二维、三维、或者更多，甚至需要压缩）
- 状态方程更复杂

#### 3.不同路径2分析
```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
        return 0;
      }
      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
      int[][] dp = new int[m][n];
      // 第一行/列障碍物之前的每个点的路径数为1，障碍物之后的为0
      for(int i = 0; i < n && obstacleGrid[0][i] == 0; i++){
          dp[0][i] = 1;
      }
      for(int j = 0; j < m && obstacleGrid[j][0] == 0; j++){
          dp[j][0] = 1;
      }
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
	    // 障碍物的点不参与计算，默认为0。
            if(obstacleGrid[i][j] == 0){
		// 不是障碍物的点的路径数为其上点和其左点的路径和
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
      }
      return dp[m-1][n-1];
    }
}
```
###  二、字符串
#### 1.特点
- 在java中字符串是不可变的
- 一旦修改就会产生一个新的对象

#### 2.常用处理算法
- 转为字符数组
- 双指针
- 高级的需要动态规划
