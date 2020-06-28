学习笔记

## 所学数据结构
#### 1.数组
- 概念：数组是一种**线性表数据结构**，用一组**连续的内存空间**存储一组**相同类型**的数据。
- java中定义方式：
		int[] arr1 = new int[3];
        int[] arr2 = {1,2,3};
        int[] arr3 = new int[]{1,2,3};
- 特点：查找快，增删慢。
- 时间复杂度：查找：O(1)；插入、删除：O(n)。

#### 2.链表

* 概念：链表是一种物理存储单元上**非连续、非顺序**的存储结构，数据元素的逻辑顺序是通过链表中的指针连接次序实现的。
* 分类：单向链表、双向链表、循环链表。
* java中实现方式：LinkedList，LinkedList是由双向链表实现。
* 特点：插入、删除快，查找慢。
* 时间复杂度：查找：O(n)；插入、删除：O(1)。
* 工程中应用：LRU Cache。

#### 3.跳表

* 概念：跳表是基于有序链表的，需要维护多层次的索引层。**只能用于元素有序的情况。**
* 特点：插入、删除、查找都快。
* 时间复杂度：查找、插入、删除：O(log n)。
* 缺点：维护成本高，增加删除都需要更新索引；空间复杂度较高O(n)。
* 设计思想：升维，空间换时间。
* 工程中应用：Redis、LevelDB。

#### 4.栈

* 概念：栈是一种只能一端存取数据并且遵循“先进后出”的线性数据结构。
* 特点：先进后出。
* 时间复杂度：添加、删除：O(1)。
* java中实现方式：Stack，底层由数组实现。

#### 5.队列

* 概念：队列是一种“先进先出”的线性数据结构。
* 特点：要求数据只能从一端进，从另一端出；先进先出。
* 时间复杂度：添加、删除：O(1)。
* java中实现方式：接口Queue，常用实现类ArrayDeque、PriorityQueue。

#### 6.双端队列Deque

* 概念：双端队列是一种可以在两端都可以存取数据的线性数据结构。
* 特点：两端都可以存取数据。
* 时间复杂度：插入、删除：O(1)。
* java中实现方式：接口Deque，常用实现类ArrayDeque、LinkedList。

#### 7.优先队列PriorityQueue

* 概念：优先队列是元素被赋予了优先级，最大优先级元素先出。
* 特点：最大优先级元素先出。
* 时间复杂度：插入O(1)；取出O(log n)。
* java中实现方式：PriorityQueue。

------------
## 新的API 改写 Deque 的代码
```java
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a"); // 对列前端添加
        deque.addFirst("b"); // 对列前端添加
        deque.addFirst("c"); // 对列前端添加
        deque.addLast("d"); // 对列后端添加
        deque.addLast("e"); // 对列后端添加
        deque.addLast("f"); // 对列后端添加
        deque.push("g"); // 对列前端添加
        deque.add("h"); // 对列后端添加
        System.out.println(deque);

        System.out.println(deque.removeFirst()); // 取出第一个并删除元素
        System.out.println(deque.removeLast()); // 取出最后一个并删除元素

        System.out.println(deque.peek()); // 取出第一个，不删除
        System.out.println(deque.peekFirst()); // 取出第一个，不删除
        System.out.println(deque.peekLast()); // 取出最后一个，不删除
        System.out.println(deque.poll()); // 取出第一个并删除元素
        System.out.println(deque.pollFirst()); // 取出第一个并删除元素
        System.out.println(deque.pollLast()); // 取出最后一个并删除元素
        System.out.println(deque.pop()); // 取出第一个并删除元素

        System.out.println(deque);
        while (!deque.isEmpty()) { // 判断队列是否为空
            System.out.println(deque.pop()); // 弹出元素
        }
        System.out.println(deque);
```

------------