package com.DataStructure.AdvanceSort;

/**
 * 划分算法的思想:
 * 划分算法有两个指针开始工作，两个指针分别指向数组的两头，在左边的指针leftPtr向右移动，遇到比枢纽大的数据项时停下来，
 * 而在右边的指针rightPtr向左移动，遇到比枢纽小的数据项时停下来
 * 当两个内层while循环都退出后leftPtr和rightPtr都指找在数组上错误一方位置上的数据项，所以交换这两个数据项
 * 当两个指针相遇的时候，整个数组划分完毕
 */
public class Partition {

    public static void partition(int[] array,int pivot) {
        int leftPtr = 0;
        int rightPtr = array.length;
        while (true) {
            while (leftPtr < array.length && array[++leftPtr] < pivot) ;
            while (rightPtr > 0 && array[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                int tmp;
                tmp = array[leftPtr];
                array[leftPtr] = array[rightPtr];
                array[rightPtr] = tmp;
            }
        }
    }
}
