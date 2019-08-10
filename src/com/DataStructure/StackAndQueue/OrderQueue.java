package com.DataStructure.StackAndQueue;

/**
 * 队列的顺序存储结构实现
 * @param <E>
 */
public class OrderQueue<E> {
    private Object[] data = null;
    private int maxSize;
    private int tail;
    private int front;

    public OrderQueue() {
        this(10);
    }

    public OrderQueue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = 0;
            tail = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0："+initialSize);
        }
    }

    public boolean isEmpty() {
        return tail == 0 ? true : false;
    }
}
