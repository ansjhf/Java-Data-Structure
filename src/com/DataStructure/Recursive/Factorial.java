package com.DataStructure.Recursive;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 自然数由1~n的n个数连乘积叫作n的阶乘，记作n!
 */
public class Factorial {

    /**
     * Task:for循环实现阶乘
     * @param n
     * @return
     */
    public static long getFactorialByFor(int n) {
        long result = 1;
        if (n < 0) {
            throw new IllegalArgumentException("必须为正整数！");
        }
        for (int i = 1; i <= n; i++) {
            result =result * i;
        }
        return result;
    }

    /**
     * Task: 递归实现阶乘
     * @param n
     * @return
     */
    public static long getFactorialByRecursion(int n) {
        long result = 1;
        if (n < 0) {
            throw new IllegalArgumentException("必须为正整数！");
        }
        if (n == 1) {
            return 1;
        } else {
            result = n * getFactorialByRecursion(n - 1);
            return result;
        }
    }

    /**
     * Task: 数组实现阶乘
     * @param n
     * @return
     */
    public static long getFactorialByArray(int n) {
        long[] arr = new long[21];
        arr[0] = 1;

        int last = 0;
        if (n >= arr.length) {
            throw new IllegalArgumentException("穿入的值过大！");
        }
        if (n < 0) {
            throw new IllegalArgumentException("必须为正整数");
        }
        while (last < n) {
            arr[last + 1] = arr[last] * (last + 1);
            last++;
        }
        return arr[n];
    }

    /**
     * Task:利用BigInteger计算阶乘
     * @param n
     * @return
     */
    public static synchronized BigInteger getFactorialByBigInteger(int n) {
        ArrayList list = new ArrayList();
        list.add(BigInteger.valueOf(1));
        for (int i = list.size(); i <= n; i++) {
            BigInteger lastfact = (BigInteger)list.get(i - 1);
            BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(i));
            list.add(nextfact);
        }
        return (BigInteger) list.get(n);
    }
}

