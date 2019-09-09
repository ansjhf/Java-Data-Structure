package com.DataStructure.Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap <T extends Comparable<T>>{

    private List<T> mHeap;
    public MaxHeap(){
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
     * Task:删除最大堆中的data
     * @param data
     * @return 0，成功；-1，失败
     */
    public int remove(T data) {
        //若"堆"已空，返回-1
        if (mHeap.isEmpty() == true)
            return -1;

        //获取data在数组中的索引
        int index = mHeap.indexOf(data);
        if (index == -1)
            return -1;

        int size = mHeap.size();
        mHeap.set(index, mHeap.get(size - 1)); //用最后的元素补填
        mHeap.remove(size - 1); //删除最后的元素

        if (mHeap.size() > 1) {
            filterDown(index,mHeap.size()-1); //从index号位置开始自上而下调整
        }
        return 0;
    }

    /**
     * Task:最大堆向上调整算法(从start开始向上知道0，调整堆)
     * 父节点为(N-1)/2
     * @param start 被上调节点的起始位置(一般为数组的最后一个元素的索引)
     */
    private void filterUp(int start) {
        int current = start;
        int parent = (current - 1) / 2;
        T tmp = mHeap.get(current);

        while (current > 0) {
            int cmp = mHeap.get(parent).compareTo(tmp);
            if (cmp >= 0) {
                break;
            } else {
                mHeap.set(current, mHeap.get(parent));
                current = parent;
                parent = (parent - 1) / 2;
            }
        }
        mHeap.set(current, tmp);
    }

    /**
     * Task:最大堆向下调整算法(从start开始直到0，调整堆)
     * 数组实现的堆中，第N个节点的左节点的索引值是（2N+1)，右节点的索引值是(2N+2)
     * @param start 被下调节点的起始位置(一般为0，表示从第一个开始)
     * @param end 截至范围(一般为数组中的最后一个元素的索引)
     */
    private void filterDown(int start,int end) {
        int current = start;
        int left = 2 * current + 1;
        T tmp = mHeap.get(current);

        while (left <= end) {
            //left为左节点，left为右节点
            int cmp = mHeap.get(left).compareTo(mHeap.get(left + 1));
            if (left < end && cmp < 0)
                left++; //左右节点中选择较大的，即mHeap[left+1]
            cmp = tmp.compareTo(mHeap.get(left));
            if (cmp >= 0) {
                break; //调整结束
            } else {
                mHeap.set(current, mHeap.get(left));
                current = left;
                left = 2 * left + 1;
            }
        }
        mHeap.set(current, tmp);
    }

}
