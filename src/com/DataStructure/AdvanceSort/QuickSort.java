package com.DataStructure.AdvanceSort;

public class QuickSort {

    private int[] array ;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void recQuickSort() {
        Sort(0, array.length - 1);
    }

    private void Sort(int left, int right) {
        if (right - left <= 0) {    // if size <= 1,already sorted
            return;
        } else {
            int pivot = array[right];
            int partition = partitionIt(left, right, pivot);
            Sort(left, partition - 1);
            Sort(partition + 1, right);
        }
    }

    private int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (leftPtr<right && array[++leftPtr] < pivot) ;
            while (rightPtr > 0 && array[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int dex1, int dex2) {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }

}
