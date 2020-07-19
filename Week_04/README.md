学习笔记
## 1.深度优先搜索（DFS）
从根节点点一直往深处走，走不动就返回选择另一条分支往深处走，直到所有的节点遍历完。
#### 树的DFS模板
```java
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root == null){
            return allResults;
        }
        travel(root, 0, allResults);
        return allResults;
    }
    
    private void travel(TreeNode root, int level, List<List<Integer>> results){
        if(results.size() == level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left != null){
            travel(root.left, level+1, results);
        }
        if(root.right != null){
            travel(root.right, level+1, results);
        }
    }
```
#### DFS模板（通用）
```java
Set<Integer> visited = new HashSet<Integer>();
void dfs(Node node, Set<Integer> visited){
    if(!visited.contains(node.val)){
        visited.add(node);
    }
    // process current level
    for(Node child : node.children){
       if(!visited.contains(child.val)){
         dfs(child, visited);
       }
    }
}
```
----
## 2.广度优先搜索（BFS）
   BFS是从根节点开始，沿着树(图)的宽度遍历树(图)的节点。如果所有节点均被访问，则算法中止。一般用队列数据结构来辅助实现BFS算法。

#### 树的BFS模板
```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
	val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```
#### BFS模板（通用）
```java
Set<Integer> visited = new HashSet<Integer>();
public void bfs(Node root) {
    Queue<Node> nodes = new LinkedList<>();
    nodes.offer(root);
    visited.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            Node node = nodes.poll();
            for(Node child : node.children){
		if(!visited.contains(child.val)){
			visited.add(child);
			nodes.offer(child);
	        }
	    }
        }
    }
}
```
----
## 3.贪心算法
- 概念：贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

- 与动态规划区别：贪心算法对于每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据之前的结果对当前进行进行选择。有回退功能。

- 适用场景：问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。
----
## 4.二分查找（Binary Search）
+ 前提：
	+ 1.目标函数单调性（单调递增或者递减）
	+ 2.存在上下边界（bounded）
	+ 3.能够通过索引访问（index accessable）
+ 模板
```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1;
	while (left <= right) {
		// 避免值很大时超出int返回
		int mid = left + (rigth - left);
		if (array[mid] == target) {
			return mid;
		} else if (array[mid] < target) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	return -1;
}
```