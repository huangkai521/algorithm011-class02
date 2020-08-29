学习笔记
学习笔记
###  一、字典树（Trie）
#### 1.基本结构
- 概念：字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
- 优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

#### 2.性质
- 结点本身不存完整的单词；
- 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串。
- 每个结点的所有子结点路径代表的字符都不相同。

#### 3.核心思想
- Trie树的核心思想是空间换时间。
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

#### 4.模板
```java
public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
	// 插入
    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
	// 搜索
    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return  node != null && node.isEnd;
    }
	// 判断是否以prefix开头
    public boolean startsWith(String prefix){
        return searchPrefix(prefix) != null;
    }
	// 搜索前缀
    public TrieNode searchPrefix(String prefix){
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.get(c);
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    class TrieNode {

        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode (){
            links = new TrieNode[R];
        }
        public boolean containsKey(char c){
            return links[c-'a'] != null;
        }
        public TrieNode get(char c){
            return links[c-'a'];
        }
        public void put(char c, TrieNode node){
            links[c-'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
}
```
###  二、并查集（Disjoint Set）
#### 1.基本结构
- 用来处理一些不相交集合的合并和查询问题。

#### 2.操作
- 初始化：每个点所在集合初始化为自身。
- 查找：查到元素所在集合，即根节点。
- 合并：将两个元素所在的集合合并为一个集合。通常来说，合并之前，应先判断两个元素是否属于同一集合，这可用上面的“查找”操作实现。

#### 3.模板
```java
public class UnionFind {
    private int count;
    private int[] parent;
    public UnionFind(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p){
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
```