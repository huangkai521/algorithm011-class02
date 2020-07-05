package com.kevin.algorithm.homework2;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 347. 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 *
 * Author Kevin.Huang
 * Date 2020/7/5
 * Time 22:52
 */
public class TopKFrequentElementSolution {

    /**
     * 思路：
     * 1.定义一个HashMap记录值及其出现次数，
     * 2.使用小顶堆排序，元素超过K，弹出顶元素。
     * 时间复杂度：O(nlogK)
     * 空间复杂度：O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length== 0 || k == 0) {
            return new int[0];
        }
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        Set<Map.Entry<Integer, Integer>> entries = counter.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] result = new int[priorityQueue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(new TopKFrequentElementSolution().topKFrequent(nums,1)));
    }

}
