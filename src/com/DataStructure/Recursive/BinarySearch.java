package com.DataStructure.Recursive;

/**
 * 二分查找，非递归实现以及递归的实现
 * 要求所查找的数组已有序,并且其中元素已实现Comparable<T>接口,如Integer、String等.
 */
public class BinarySearch <T extends Comparable<T>> {

    private T[] data;

    public BinarySearch(T[] data) {
        this.data = data;
    }

    /**
     * 非递归实现
     * @param key
     * @return
     */
    public int search(T key) {
        int left = 0;
        int right = data.length - 1;
        int mid;

        if (data == null) {
            return -1;
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (key.compareTo(data[mid]) < 0) {
                right = mid - 1;
            } else if (key.compareTo(data[mid]) > 0) {
                left = mid + 1;
            } else if (key.compareTo(data[mid]) == 0) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     * @param key
     * @return
     */
    public int searchByRecursively(T key) {
        if (data == null) {
            return -1;
        }
        return doSearchRecursively(0, data.length - 1, key);
    }

    private int doSearchRecursively(int left, int right, T key) {
        int mid;
        int result;

        if (left <= right) {
            mid = (left + right) / 2;
            result = key.compareTo(data[mid]);
            if (result < 0) {
                return doSearchRecursively(left, mid - 1, key);
            } else if (result > 0) {
                return doSearchRecursively(mid + 1, right, key);
            } else if (result == 0) {
                return mid;
            }
        }
        return -1;
    }
}
