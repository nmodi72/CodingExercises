package main.java.Impl.concept.Cache;

import java.util.HashMap;

/**
 * Created by nmodi on 9/25/18.
 */
public class LRUCache {

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node oldNode = map.get(key);
            oldNode.value = value;
            remove(oldNode);
            setHead(oldNode);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
            setHead(oldNode);
            return oldNode.value;
        }
        return -1;
    }

    public void remove(Node node){
        if(node.prev != null){
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    public void setHead(Node node){
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(end == null) {
            end = head;
        }
    }
}
