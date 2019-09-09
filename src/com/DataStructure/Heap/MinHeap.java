package com.DataStructure.Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

    private List<T> mHeap;

    public MinHeap(){
        this.mHeap = new ArrayList<T>();
    }

    /**
     * Task:将data插入到二叉堆中
     * @param data
     */
    public void insert(T data) {
        int size = mHeap.size();
        mHeap.add(data);
        filterUp(size);
    }

    /**
     * Task:最小堆的删除
     * @param data
     * @return
     */
    public int remove(T data) {
        if (mHeap.isEmpty() == true)
            return -1;

        int index = mHeap.indexOf(data);
        if (index == -1)
            return -1;
        int size = mHeap.size();
        mHeap.set(index, mHeap.get(size - 1));
        if (mHeap.size() > 1)
            filterdown(index, mHeap.size() - 1);
        return 0;
    }

    /**
     * Task:最小堆的向下调整算法
     * @param start
     * @param end
     */
    private void filterdown(int start, int end) {
        int current = start;
        int left = 2 * current + 1;
        T tmp = mHeap.get(current);

        while (left <= end) {
            int cmp = mHeap.get(left).compareTo(mHeap.get(left + 1));
            if (left < end && cmp > 0)
                left++;
            cmp = tmp.compareTo(mHeap.get(left));
            if (cmp <= 0) {
                break;
            } else {
                mHeap.set(current, mHeap.get(left));
                current = left;
                left = 2 * left + 1;
            }
        }
        mHeap.set(current, tmp);
    }

    /**
     * Task:最小堆的向上调整算法
     * @param start
     */
    private void filterUp(int start) {
        int current = start;
        int parent = (current - 1) / 2;
        T tmp = mHeap.get(current);

        while (current > 0) {
            int cmp = mHeap.get(parent).compareTo(tmp);
            if (cmp <= 0) {
                break;
            } else {
                mHeap.set(current, mHeap.get(parent));
                current = parent;
                parent = (parent - 1) / 2;
            }
        }
        mHeap.set(current, tmp);
    }
}
