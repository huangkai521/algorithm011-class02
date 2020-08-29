package com.kevin.algorithm.homework7;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * Author Kevin
 * Date 2020/8/29
 * Time 22:55
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int f = 0, s = 1, t = 0;
        for (int i = 1; i <= n; i++) {
            t = s + f;
            f = s;
            s = t;
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(5));
    }
}
