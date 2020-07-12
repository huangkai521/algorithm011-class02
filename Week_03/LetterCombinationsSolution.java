package com.kevin.algorithm.homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Author Kevin.Huang
 * Date 2020/7/12
 * Time 23:20
 */
public class LetterCombinationsSolution {

    Map<Character,String> letterMap = new HashMap(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        letterCombinationsHelper("", ans, digits, 0);
        return ans;
    }

    private void letterCombinationsHelper(String str, List<String> ans, String digits, int i) {
        if (i == digits.length()) {
            ans.add(str);
            return;
        }
        char c = digits.charAt(i);
        String letters = letterMap.get(c);
        for (int j = 0; j < letters.length();j ++) {
            letterCombinationsHelper(str+letters.charAt(j), ans, digits, i+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsSolution().letterCombinations("234"));
    }
}
