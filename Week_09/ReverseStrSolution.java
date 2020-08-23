package com.kevin.algorithm.homework9;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 541. 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * Author Kevin
 * Date 2020/8/23
 * Time 15:23
 */
public class ReverseStrSolution {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i+2*k) {
            int start = i, end = Math.min(i + k - 1, chars.length-1);
            while (start < end) {
                char temp = chars[end];
                chars[end--] = chars[start];
                chars[start++] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStrSolution().reverseStr("abcdefg", 2));
    }
}
