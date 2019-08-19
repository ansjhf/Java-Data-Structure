package com.DataStructure.LinkedList;

public class SortLinkedList<T extends Comparable<T>> {

    private Node<T> first;
    private int size;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> prev = null;
        Node<T> current = first;
        while (current != null && (data.compareTo(current.data))>0) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        newNode.next = current;
    }

    public Node<T> deleteFirst(){
        Node<T> temp = first;
        first = first.next;
        return temp;
    }

    public Node<T> delete(T t) {
        if (size == 0) {
            return null;
        } else {
            if (first.data.equals(t)) {
                Node<T> temp = first;
                first = first.next;
                return temp;
            }
        }
        Node<T> p = first;
        Node<T> q = first;
        while (!p.data.equals(t)) {
            if (p.next == null) {
                return null;
            } else {
                q = p;
                p = p.next;
            }
        }
        q.next = p.next;
        return p;
    }

    public Node<T> find(T t) {
        Node<T> find = first;
        while (find != null) {
            if (!find.data.equals(t)) {
                find = find.next;
            } else {
                break;
            }
        }
        return find;
    }

    private class Node<T>{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }
}
