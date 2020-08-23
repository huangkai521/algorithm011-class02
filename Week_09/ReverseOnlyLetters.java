package com.kevin.algorithm.homework9;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * 917. 仅仅反转字母
 *
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 *
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * Author Kevin
 * Date 2020/8/23
 * Time 17:21
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (isLetter(S.charAt(i))) {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (isLetter(S.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 判断是否字母
     *
     * @param c 字符
     * @return true:是；false:否
     */
    private boolean isLetter(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("Test1ng-Leet=code-Q!").equals("Qedo1ct-eeLg=ntse-T!"));
    }
}
