package com.kevin.algorithm.homework2;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * Author Kevin.Huang
 * Date 2020/6/30
 * Time 21:48
 */
public class AnagramValidSolution {
    /**
     * 思路：
     * 1.两个字符串长度不相等直接返回false
     * 2.遍历第一个数组，使用计数器记录其字符出现的次数。
     * 3.遍历第二个数组，遍历到的字符对应的次数-1，如果该字符次数小于0，返回false。
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t==null || s.length() != t.length()) return false;
        int[] counter = new int[26]; // 该题明确说明是小写字母，所以数组长度定为26
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new AnagramValidSolution().isAnagram("a","b"));
        System.out.println(new AnagramValidSolution().isAnagram("anagram","nagaram"));
    }
}
