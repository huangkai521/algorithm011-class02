package com.kevin.algorithm.homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。

 * Author Kevin.Huang
 * Date 2020/7/1
 * Time 22:13
 */
public class GroupAnagramsSolution {
    /**
     * 使用#a出现次数#b出现次数......#z出现次数 来记录一个字符串的字符出现次数
     * 如果两个字符串的一致，说明是异位词
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // 存储异位词分组
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 查询该字符串是否出现过异位词，不能直接查询，要按照指定格式转换为key再查询
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String str){
        int[] counter = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counter[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < counter.length; i++) {
            sb.append("#");
            sb.append(counter[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = null;
        System.out.println(new GroupAnagramsSolution().groupAnagrams(strs).toString());
    }
}
