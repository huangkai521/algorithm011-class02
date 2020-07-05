package com.kevin.algorithm.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 * [1,null,3,2,4,null,5,6]
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * Author Kevin.Huang
 * Date 2020/7/5
 * Time 21:45
 */
public class NAryTreePreorderTraversalSoluton {

    /**
     * 思路：前序遍历的顺序自上到下，自左到右。
     * 将第一个根、右、左元素以此入栈，弹栈，list里添加该值。如果有子节点，继续上面的。
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            List<Node> children = node.children;
            if (children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return list;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

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
        System.out.println(new NAryTreePreorderTraversalSoluton().preorder(root).toString());
    }
}
