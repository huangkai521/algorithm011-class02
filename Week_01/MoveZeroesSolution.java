package com.kevin.algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 *
 * Author Kevin.Huang
 * Date 2020/6/27
 * Time 15:31
 */
public class MoveZeroesSolution {
    /**
     * 思路：快慢指针。
     * 遍历数组，使用一个新的指针(慢指针)记录不为0的元素。
     * 遍历过程中遇到不为的0元素，并且慢指针不是当前遍历到的指针，
     * 使用新的指针记录下该元素，并将当前元素的值置为0。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0; // 慢指针
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 此判断的目的是避免一开始没有出现元素为0的情况，元素重合的情况。
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++; // 遇到不为0的元素，慢指针加一步
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroesSolution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
