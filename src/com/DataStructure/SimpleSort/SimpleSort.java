package com.DataStructure.SimpleSort;

import java.util.Arrays;

public class SimpleSort {

    /**
     * 冒泡排序
     * ①比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③针对所有的元素重复以上的步骤，除了最后一个。
     * ④持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param sourceArray
     * @return
     */
    public static int[] bubbleSort(int[] sourceArray) {

        //对数组来源进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        //经过arr.length-1轮循环
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * ①首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * ②再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * ③重复第二步，直到所有元素均排序完毕。
     * @param sourceArray
     * @return
     */
    public static int[] SelectionSort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        //总共要经过N-1轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            //每轮需要比较N-i次
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    //记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * ①将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * ②从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     * @param sourceArray
     * @return
     */
    public static int[] InsertSort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            //记录要插入的数据
            int temp = arr[i];

            //从眼角排序的序列最右边开始进行比较，找到比其小的数
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            //存在比其小的数，插入
            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }
}
