package com.kevin.algorithm.homework6;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * Author Administrator
 * Date 2020/8/2
 * Time 20:40
 */
public class LongestValidParenthesesSolution {

    /**
     * 判断左右括号的个数
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;
        if (s == null) {
            return maxLength;
        }
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, right * 2);
            } else if (right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ('(' == s.charAt(i)) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, left * 2);
            } else if (left > right){
                left = right = 0;
            }
        }
        return maxLength;
    }

    /**
     * 使用动态规划。
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int maxLength = 0;
        if (s == null) {
            return maxLength;
        }
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (')' == s.charAt(i)) {
                if ('(' == s.charAt(i - 1)) {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if (i - dp[i-1] - 1 >= 0 && '(' == s.charAt(i - dp[i-1] -1)) {
                    dp[i] = dp[i - 1] + (i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0) + 2;
                }
                maxLength = Math.max(dp[i], maxLength);
            }
        }
        return maxLength;
    }

    /**
     * 使用栈，遇到"("入栈当前角标，遇到")"弹栈，如果栈为空，说明")"比"("多，到这个")"角标说明不再是有效括号。
     * 栈不为空就使用当前角标减去栈顶元素(栈顶元素可能是字符串原始的开头-1，也可能是之前多余的")"的角标)。
     *
     * @param s 字符串
     * @return 最长有效括号长度
     */
    public int longestValidParentheses1(String s) {
        int maxLength = 0;
        if (s == null) {
            return maxLength;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);// 很巧妙的
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParenthesesSolution().longestValidParentheses("()()())()()()()()"));
    }
}
