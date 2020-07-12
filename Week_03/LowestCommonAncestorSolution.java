package com.kevin.algorithm.homework3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * Author Kevin.Huang
 * Date 2020/7/12
 * Time 22:06
 */
public class LowestCommonAncestorSolution {

    Map<Integer,TreeNode> parentMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        getParentNode(root);
        // 寻找p的所有父节点
        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }
        // 寻找q的所有父节点，如果该节点的值在P的父节点的集合中出现过，
        // 说明这个节点就是最近公共祖先
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    // 把每个节点的值及其父节点放入hashMap
    private void getParentNode(TreeNode node){
        if (node.left != null) {
            parentMap.put(node.left.val, node);
            getParentNode(node.left);
        }
        if (node.right != null) {
            parentMap.put(node.right.val, node);
            getParentNode(node.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
