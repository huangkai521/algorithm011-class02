package com.kevin.algorithm.homework9;

/**
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 680. 验证回文字符串 Ⅱ
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 *
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * 注意:字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * Author Kevin
 * Date 2020/8/23
 * Time 19:07
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return validPalindrome(s,l+1, r) || validPalindrome(s, l,r-1);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("abab"));
    }

}
