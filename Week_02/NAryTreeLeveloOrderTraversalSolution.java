package com.kevin.algorithm.homework2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 例如，给定一个 3叉树 :
 *  [1,null,3,2,4,null,5,6]
 * 返回其层序遍历:
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * Author Kevin.Huang
 * Date 2020/7/5
 * Time 22:08
 */
public class NAryTreeLeveloOrderTraversalSolution {

    /**
     * 思路：记录全局深度，一层一层来，递归。
     * 时间复杂度：O(n)
     * 空间复杂度：最好情况O(logn)，最坏情况O(n)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        levelOrderHelper(root, 1, list);
        return list;
    }

    /**
     * 层次遍历树
     *
     * @param node 当前节点
     * @param level 层次
     * @param list 结果集合
     */
    private void levelOrderHelper(Node node, int level, List<List<Integer>> list){
        if (node != null) {
            // 如果深度大于集合长度，说明向下一层，初始化一个集合
            if (level > list.size()) {
                list.add(new ArrayList<>());
            }
            list.get(level - 1).add(node.val);
            List<Node> children = node.children;
            if (children != null) {
                for (Node childNode : children) {
                    levelOrderHelper(childNode, level + 1, list);
                }
            }
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        List<Node> children = new ArrayList<>();
        children.add(node1);
        children.add(node2);
        children.add(node3);
        root.children = children;
        System.out.println(new NAryTreeLeveloOrderTraversalSolution().levelOrder(root).toString());
    }
}
