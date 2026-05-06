/**
 * Problem: LRU Cache
 * Platform: LeetCode 146
 *
 * Description:
 * Design a data structure that follows the Least Recently Used (LRU) cache policy.
 *
 * Implement:
 * - LRUCache(int capacity)
 * - int get(int key) → return value if exists, else -1
 * - void put(int key, int value) → update or insert value
 *
 * Constraint:
 * - When capacity is exceeded, remove the least recently used element
 *
 * Example:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);    // returns 1
 * cache.put(3,3);  // evicts key 2
 * cache.get(2);    // returns -1
 *
 * Approach:
 * - Use HashMap for O(1) access
 * - Use Doubly Linked List to maintain order
 *
 * - Most recently used → near head
 * - Least recently used → near tail
 *
 * Operations:
 * - get():
 *      Move node to front (recently used)
 *
 * - put():
 *      If exists → update + move to front
 *      If new:
 *          If capacity full → remove LRU (tail.prev)
 *          Insert new node at front
 *
 * Time Complexity: O(1) for get and put
 * Space Complexity: O(capacity)
 */

import java.util.*;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {

        // 🔹 Hardcoded operations
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // evicts key 2

        System.out.println(cache.get(2)); // -1

        cache.put(4, 4); // evicts key 1

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        remove(node);
        insertAtFirst(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            remove(node);
            insertAtFirst(node);
        } else {

            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);

            insertAtFirst(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}