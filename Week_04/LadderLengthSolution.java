package com.kevin.algorithm.homework4;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * Author Kevin.Huang
 * Date 2020/7/19
 * Time 22:10
 */
public class LadderLengthSolution {

    /**
     * 思路：使用广度优先。
     * 对起始单词的每个字符进行a-z替换，判断字典表中是否存在，放入队列，记录已被访问。
     * 若转换后的单词等于结束单词，返回步数+1，因为最后一个单词也算o。
     * 图的最短路径就使用广度优先，一层一层的。
     *
     * @param beginWord 起始单词
     * @param endWord 结束单词
     * @param wordList 字典
     * @return 最短转换序列的长度，不存在返回0
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordList.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String word = queue.poll();
                char[] charArray = word.toCharArray();
                // 替换每一个字符
                for (int j = 0; j < charArray.length; j++) {
                    // 记录当前字符，复原使用
                    char originChar = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }
                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);
                        // 字典表里包含转换的单词
                        // 判断是不是endWord，是的话就结束
                        // 不是的话就判断是否访问过，没有访问过就加入队列，添加到visited
                        // 如果都不不包含的话，queue里面会空的，会结束迭代
                        if (wordSet.contains(nextWord)) {
                            // 到达最后
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                queue.offer(nextWord);
                            }
                        }
                    }
                    charArray[j] = originChar;
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lat","log","cog");
        System.out.println(new LadderLengthSolution().ladderLength(beginWord, endWord, wordList));
    }
}
