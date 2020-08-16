package com.kevin.algorithm.homework8;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * Author Kevin
 * Date 2020/8/16
 * Time 22:45
 */
public class IsAnagramSolution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr1 = countLetter(s);
        int[] arr2 = countLetter(t);
        return Arrays.equals(arr1, arr2);
    }

    private int[] countLetter(String str){
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagramSolution().isAnagram("anagram", "nagaram"));
        System.out.println(new IsAnagramSolution().isAnagram("rat", "car"));
    }
}
