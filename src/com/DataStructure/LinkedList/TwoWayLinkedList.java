package com.DataStructure.LinkedList;

import com.sun.tools.hat.internal.model.Root;

/**
 * 双向链表的实现
 * 可在表头，表尾插入删除数据，也可双向历遍
 */
public class TwoWayLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public TwoWayLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean addHead(Object data) {
        if (data == null) {
            return false;
        }
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
//            size++;
//            return true;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
//            size++;
//            return true;
        }
        size++;
        return true;
    }

    public boolean addTail(Object data) {
        if (data == null) {
            return false;
        }
        Node newNode = new Node(data);
        if (size == 0) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteHead() {
        if (size == 0) {
            return false;
        } else {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
    }

    public boolean deleteTail() {
        if (size == 0) {
            return false;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
            return true;
        }
    }

    public void set(int index, Object data) {
        if (index >= 0 && index < size) {
            Node x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            x.data = data;
        }
    }

    public Object get(int index){
        if (!(index >= 0 && index < size)) {
            return null;
        } else {
            Node x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x.data;
        }
    }

    /**
     * Task：转数组，从头部历遍
     * @return
     */
    public Object[] toArray() {
        Object[] obj = new Object[size];
        Node x = head;
        for (int i = 0; i < size; i++) {
            obj[i] = x.data;
            x = x.next;
        }
        return obj;
    }

    /**
     * Task：转数组，从尾部历遍
     * @return
     */
    public Object[] toArrayWithTail() {
        Object[] obj = new Object[size];
        Node x = tail;
        for (int i = 0; i < size; i++) {
            obj[i] = x.data;
            x = x.prev;
        }
        return obj;
    }

    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data) {
            this.data = data;
        }
    }
}
