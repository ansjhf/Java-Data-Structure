package com.DataStructure.LinkedList;

/**
 * 单链表的实现
 */
public class SingleLinkedList{

    private int size;
    private Node root;

    public SingleLinkedList(){
        size = 0;
        root = null;
    }

    public boolean add(Object data) {
        Node newNode = new Node(data);
        if (data == null) {
            return false;
        }
        if (size == 0) {
            root = newNode;
        } else {
            newNode.next = root;
            root = newNode;
        }
        size++;
        return true;
    }


    public Object delete() {
        Object obj = root.data;
        root = root.next;
        size--;
        return obj;
    }

    public boolean set(int index, Object data) {
        if (!(index >= 0 && index < size)) {
            return false;
        } else {
            Node x = root;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            x.data = data;
        }

        return true;
    }

    public Object get(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + (index+1) + ", Size: " + size);
        } else {
            Node x = root;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x.data;
        }
    }

    public boolean contains(Object search) {
        if (search == null || this.root == null) {
            return false;
        } else {
            for (Node x = root; x != null; x = x.next) {
                if (search.equals(x.data)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    private class Node{
        private Object data;
        private Node next;

        Node(Object data) {
            this.data = data;
        }

    }

    public Object[] toArray() {
        Object obj[] = new Object[size];
        Node x = root;
        for (int i = 0; i < size; i++) {
            obj[i]=x.data;
            x = x.next;
        }
        return obj;
    }
}
