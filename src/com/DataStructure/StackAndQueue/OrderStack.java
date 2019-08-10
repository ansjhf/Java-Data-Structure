package com.DataStructure.StackAndQueue;

/**
 * 栈的顺序存储结构实现
 * @param <E>
 */
public class OrderStack<E> {

    private Object[] data = null;
    private int maxSize = 0; //栈容量
    private int top = -1; //栈指针

    public OrderStack(){
        this(10); //默认栈大小为10
    }

    public OrderStack(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1 ? true : false;
    }

    /**
     * 入栈
     * @param e
     * @return
     */
    public boolean push(E e) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满，无法入栈！");
        } else {
            data[++top] = e;
            return true;
        }
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public E peek() {
        if (top == -1) {
            throw new RuntimeException("栈为空！");
        } else {
            return (E) data[top];
        }
    }

    /**
     * 出栈，并返回该元素
     * @return
     */
    public E pop() {
        if (top == -1) {
            throw new RuntimeException("栈为空！");
        } else {
            return (E) data[top--];
        }
    }

    /**
     * 返回对象在栈中的基数，以1为基数
     * @param e
     * @return
     */
    public int search(E e) {
        int i = top;
        while (top != -1) {
            if (peek() != e) {
                top--;
            } else {
                break;
            }
        }
        int result = top+1;
        top = i;
        return result;
    }
}
