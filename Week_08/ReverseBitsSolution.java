package com.kevin.algorithm.homework8;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *
 * Author Kevin
 * Date 2020/8/16
 * Time 22:36
 */
public class ReverseBitsSolution {

    public int reverseBits(int n) {
        int ans = 0, bits = 31;
        while (n != 0) {
            ans += (n & 1) << bits;
            bits--;
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBitsSolution().reverseBits(0b11111111111111111111111111111101));
    }

}
