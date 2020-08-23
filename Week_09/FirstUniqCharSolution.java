package com.kevin.algorithm.homework9;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 *
 * Author Kevin
 * Date 2020/8/23
 * Time 15:14
 */
public class FirstUniqCharSolution {

    /**
     * 思路：建立映射，记录单词出现的次数。再循环判断哪个字符出现一次。
     *
     * @param s 字符串
     * @return 第一个不重复的字符的索引
     */
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqCharSolution().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqCharSolution().firstUniqChar("loveleetcode"));
    }

}
