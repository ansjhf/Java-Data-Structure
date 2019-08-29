package com.DataStructure.AdvanceSort;

/**
 * 希尔排序
 */
public class ShellSort {

    /**
     * 首先要选取步长gap的值。选取了gap之后，就将数列分成了gap个组，对于每一个组都执行直接插入排序。
     * 在排序完所有的组之后，将gap的值减半；继续对数列进行分组，然后进行排序。
     * 重复这样的操作，直到gap<0为止。此时，数列也就是有序的了。
     * @param array
     */
    public void shellSort(int[] array) {
        int i,j,gap;
        int n = array.length;
        //gap为步长，每次减为原来的一半
        for (gap = n / 2; gap > 0; gap /= 2) {
            //共gap个组，对每一组都执行直接插入排序
            for (i = 0; i < gap; i++) {
                group_sort(array,n,i,gap);
            }
        }
    }

    /**
     * Task:对希尔排序中的单个组进行排序
     * @param array 待排序的数组
     * @param n 数组总长度
     * @param i 组的起始位置
     * @param gap 组的步长
     *
     * 组是"从i开始，将相隔gap长度的数都取出"所组成的！
     */
    void group_sort(int[] array, int n, int i, int gap) {
        int j;
        for (j = i + gap; j < n; j += gap) {
            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (array[j] < array[j - gap]) {
                int tmp = array[j];
                int k = j - gap;
                while (k >= 0 && array[k] > tmp) {
                    array[k + gap] = array[k];
                    k -= gap;
                }
                array[k + gap] = tmp;
            }
        }
    }
}
