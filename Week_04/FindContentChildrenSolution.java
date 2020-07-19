package com.kevin.algorithm.homework4;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 *
 * 示例 1:
 * 输入: [1,2,3], [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 *
 * 示例 2:
 * 输入: [1,2], [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 * Author Kevin.Huang
 * Date 2020/7/19
 * Time 18:32
 */
public class FindContentChildrenSolution {

    /**
     * 思路：
     * (1)对g和s排序；
     * (2)两个指针i、j分别记录孩子和饼干。
     * (3)如果当前的饼干尺寸满足当前孩子的胃口，两个指针移动一步。
     * 不满足的话饼干指针移动以寻找满足该孩子胃口的饼干。
     *
     * @param g 孩子们
     * @param s 饼干们
     * @return 满足的孩子数量
     */
    public int findContentChildren(int[] g, int[] s) {
        int contentChildrenNum = 0;
        if (g == null || s == null) {
            return contentChildrenNum;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                contentChildrenNum++;
                i++;
            }
            j++;
        }
        return contentChildrenNum;
    }

    public static void main(String[] args) {
        int[] g = {4,2,3,1};
        int[] s = {1,3,2,3};
        int result = new FindContentChildrenSolution().findContentChildren(g, s);
        System.out.println(result);
    }

}
