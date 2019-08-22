package com.DataStructure.Recursive;

/**
 * 三角数字：第n个三角数字是由1+……+n所得
 * eg： 1的三角数字是 1
 *      2的三角数字是 1+2=3
 *      3的三角数字是 1+2+3=6
 *      ……
 *      n的三角数字是 1+2+3+...+N
 */
public class Triangle {
    public static int getTriangleNumByFor(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        return result;
    }

    public static int getTriangleNumByMath(int n) {
        return (n * n + n) / 2;
    }

    public static int getTriangleNumByWhile(int n) {
        int result = 0;
        while (n > 0) {
            result = result + (n--);
        }
        return result;
    }

    public static int getTriangleNumByRecursive(int n) {
        int result = 0;
        if (n == 1) {
            return 1;
        }
        return result = n + getTriangleNumByRecursive(n - 1);
    }

}
