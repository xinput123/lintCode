package other;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个简单的LRU算法
 * Least Recently Used 最近最少使用，是一种缓存置换算法。
 * 在使用内存作为缓存的时候，缓存的大小一般是固定的。当缓存被占满，这个时候继续往缓存里面添加数据，就需要淘汰一部分老的数据，
 * 释放内存空间用来存储新的数据。这个时候就可以使用LRU算法了。其核心思想是：如果一个数据在最近一段时间没有被用到，那么将来
 * 被使用到的可能性也很小，所以就可以被淘汰掉。
 */
public class LruCache<k, v> {

    /**
     * 容量
     */
    private int capacity;

    /**
     * 当前有多少节点的统计
     */
    private int count;

    /**
     * 缓存节点
     */
    private Map<k, Node<k, v>> nodeMap;

    private Node<k, v> head;

    private Node<k, v> tail;

    public LruCache(int capacity) throws IllegalAccessException {
        if (capacity < 1) {
            throw new IllegalAccessException(String.valueOf(capacity));
        }
        this.capacity = capacity;
        this.nodeMap = new HashMap();
        // 初始化头结点和尾节点，利用哨兵模式减少判断头结点和尾节点为空的代码
        Node headNode = new Node(null, null);
        Node taillNode = new Node(null, null);
        headNode.next = taillNode;
        taillNode.pre = headNode;
        this.head = headNode;
        this.tail = taillNode;
    }

    public void put(k key, v value) {
        Node<k, v> node = nodeMap.get(key);
        if (node == null) {
            if (count >= capacity) {
                // 先移除一个节点
                removeNode();
            }
            node = new Node(key, value);
            // 添加节点
            addNode(node);
        } else {
            // 移动节点到头节点
            moveNodeToHead(node);
        }
    }

    public Node<k, v> get(k key) {
        Node<k, v> node = nodeMap.get(key);
        if (node != null) {
            moveNodeToHead(node);
        }

        return node;

    }

    private void removeNode() {
        Node node = tail.pre;
        // 从链表中移除
        removeFromList(node);
        nodeMap.remove(node.key);
        count--;
    }

    /**
     * 移除节点
     */
    private void removeFromList(Node<k, v> node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    private void addNode(Node<k, v> node) {
        // 添加节点到头部
        addToHead(node);
        nodeMap.put(node.key, node);
        count++;
    }

    /**
     * 添加节点到头部
     */
    private void addToHead(Node<k, v> node) {
        Node next = head.next;
        next.pre = node;

        node.next = next;
        node.pre = head;

        head.next = node;
    }

    /**
     * 移动节点到头节点
     */
    public void moveNodeToHead(Node<k, v> node) {
        // 从链表中移除
        removeFromList(node);
        // 添加节点到头部
        addToHead(node);
    }

    class Node<k, v> {
        k key;

        v value;

        Node pre;

        Node next;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }
}
