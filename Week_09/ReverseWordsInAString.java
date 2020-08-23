package com.kevin.algorithm.homework9;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 151. 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * Author Kevin
 * Date 2020/8/23
 * Time 16:08
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 去除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >=0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i+1, j+1) + " ");
            while (i >=0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("the sky is blue"));
    }
}
