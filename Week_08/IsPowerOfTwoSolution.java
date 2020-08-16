package com.kevin.algorithm.homework8;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 231. 2的幂
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 *
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 *
 * 示例 3:
 * 输入: 218
 * 输出: false
 *
 * Author Kevin
 * Date 2020/8/16
 * Time 22:30
 */
public class IsPowerOfTwoSolution {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long)n;
        return (x & -x) == x;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwoSolution().isPowerOfTwo(8));
        System.out.println(new IsPowerOfTwoSolution().isPowerOfTwo(-2147483648));
    }
}
