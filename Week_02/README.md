学习笔记
## 第二周所学数据结构

#### 1.哈希表
- 概念：哈希表（Hash table），也叫散列表，是根据关键码值（Key-value）而直接进行访问的数据结构。
- 映射：将key通过某种方式映射到表中的某个位置的方式。
- java中实现放式：HashMap、HashTable、LinkedHashMap
- 时间复杂度：查找、插入、删除：O(1)。如果散列函数设计的不好，时间复杂度会退化至O(n)。
- 工程中应用：缓存（LRU Cache）、键值对（Redis）。