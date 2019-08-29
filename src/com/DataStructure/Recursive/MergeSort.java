package com.DataStructure.Recursive;

/**
 * 并归排序的实现
 */
public class MergeSort {

    /**
     * Task:并归排序的实现思想:归并两个已经有序的数组
     * @param arrayA
     * @param arrayB
     * @return arrayC
     */
    public static int[] mergeSort(int[] arrayA, int[] arrayB){
        int aDex = 0, bDex = 0, cDex = 0;
        int[] arrayC = new int[arrayA.length + arrayB.length];
        while (aDex < arrayA.length && bDex < arrayB.length) {
            if (arrayA[aDex] < arrayB[bDex]) {
                arrayC[cDex++] = arrayA[aDex++];
            } else {
                arrayC[cDex++] = arrayB[bDex++];
            }
        }
        while (aDex < arrayA.length) {
            arrayC[cDex++] = arrayA[aDex++];
        }
        while (bDex < arrayB.length) {
            arrayC[cDex++] = arrayB[bDex++];
        }
        return arrayC;
    }

    /**
     * Task:归并排序的递归实现
     * @param arr
     */
    public static void mergeSortByRecursive(int[] arr) {
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] array, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            sort(array, lowerBound, mid);
            sort(array, mid + 1, upperBound);
            merge(array,lowerBound,mid+1,upperBound);
        }
    }

    /**
     *Task:归并
     * @param array 归并的数组
     * @param left
     * @param midRight
     * @param upperBound
     */
    private static void merge(int[] array, int left, int midRight, int upperBound) {
        int j = 0;
        int[] temp = new int[array.length];
        int lowerBound = left;
        int mid = midRight-1;
        int n = upperBound - lowerBound + 1;

        while (left <= mid && midRight <= upperBound) {
            if (array[left] < array[midRight]) {
                temp[j++] = array[left++];
            } else {
                temp[j++] = array[midRight++];
            }
        }
        while (left <= mid) {
            temp[j++] = array[left++];
        }
        while (midRight <= upperBound) {
            temp[j++] = array[midRight++];
        }

        for (int k = 0; k < n; k++) {
            array[lowerBound + k] = temp[k];
        }
    }
}
