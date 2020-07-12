package com.kevin.algorithm.homework3;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Author Kevin.Huang
 * Date 2020/7/12
 * Time 22:54
 */
public class BuildTreeHelperSolution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return buildTreeHelper(preorder, inorder);
    }

    /**
     * 思路：前序遍历是根左右，中序遍历是左根右。
     * 前序遍历结果的第一个元素就是根节点，使用根节点分割为左右子节点。
     * 依次寻找根节点，直到根节点只有一个元素。
     * @param preorder
     * @param inorder
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }
        // 寻找根节点，前序遍历的第一个节点是根节点
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1){
            root.left = null;
            root.right = null;
        } else {
            int index = getIndex(inorder, preorder[0]);
            int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
            int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderLeft.length + 1);
            int[] preorderRight = Arrays.copyOfRange(preorder, inorderLeft.length + 1, preorder.length);
            root.left = buildTreeHelper(preorderLeft, inorderLeft);
            root.right = buildTreeHelper(preorderRight, inorderRight);
        }
        return root;
    }

    private int getIndex(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(new BuildTreeHelperSolution().buildTree(preorder, inorder));
    }
}
