package com.kevin.algorithm.homework9;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 提示：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * Author Kevin
 * Date 2020/8/23
 * Time 17:00
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder words = new StringBuilder();
        String[] strs = split(s);
        for (String str : strs) {
            words.append(reverse(str)).append(" ");
        }
        return words.toString().trim();
    }

    /**
     * 根据空格分割
     *
     * @param s 待分割字符串
     * @return 分割后的字符串数组
     */
    private String[] split(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(word.toString());
                word.setLength(0);
            } else {
                word.append(s.charAt(i));
            }
        }
        words.add(word.toString());// 最后一个单词的情况
        return words.toArray(new String[words.size()]);
    }

    /**
     * 反转字符串
     *
     * @param s 待反转的字符串
     * @return 反转后的字符串
     */
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
    }
}
