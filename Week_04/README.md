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