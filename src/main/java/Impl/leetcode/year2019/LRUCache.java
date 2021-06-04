package main.java.Impl.leetcode.year2019;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUCache {

    /*
     * Explanation:
     * Using a map to simply store key value. Additionally, a LinkedHashSet is used to
     * to do a book-keeping of keys. The keys are refreshed every time there's a get/put
     * operation (by removing the key, followed immediately by put). That way, the most
     * recently accessed key is available in the last position. When the put operation
     * goes over-capacity, we find the first element (most stale), and remove it.
     */

    /*

    int capacity = 0;
    // to keep track of recently used item
    LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            set.remove(key);
            set.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            set.remove(key);
        } else if (capacity == set.size()) { // max size
            int mostStale = set.iterator().next();
            map.remove(mostStale);
            set.remove(mostStale);
        }
        map.put(key, value);
        set.add(key);
    }

    */

    /*
        Other solution with Doubly LinkedList and HashMap
     */

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
