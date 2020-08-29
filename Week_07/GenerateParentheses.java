package com.kevin.algorithm.homework7;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * Author Kevin
 * Date 2020/8/29
 * Time 21:58
 */
public class GenerateParentheses {

    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesisHelper(n, n, "", n);
        return ans;
    }

    private void generateParenthesisHelper(int leftAllow, int rightAllow, String str, int n){
        if (leftAllow == 0 && rightAllow == 0) {
            ans.add(str);
            return;
        }
        // 如果左括号可用的数量比右括号还多，剪枝
        if (leftAllow > rightAllow) {
            return;
        }
        if (leftAllow > 0) {
            generateParenthesisHelper(leftAllow - 1, rightAllow, str +"(" ,n);
        }
        if (rightAllow > 0) {
            generateParenthesisHelper(leftAllow, rightAllow - 1, str +")" ,n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3).toString());
    }

}
