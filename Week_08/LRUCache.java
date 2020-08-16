package com.kevin.algorithm.homework8;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 146. LRU缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 * Author Administrator
 * Date 2020/8/16
 * Time 22:55
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){
        }
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    DLinkedNode head, tail;
    private int capacity, size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    // 获取
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    // 添加
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            size++;
            node = new DLinkedNode(key, value);
            cache.put(key,node);
            addToHead(node);
            if (size > capacity) {
                size--;
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    // 移动至头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    // 移除该节点，在链表中移动位置使用
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // 添加至头部
    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
