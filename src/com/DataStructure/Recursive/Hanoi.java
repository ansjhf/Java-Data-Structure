package com.DataStructure.Recursive;

/**
 * 汉诺塔问题用递归思想的算法
 */
public class Hanoi {

    private static int i = 0;

    private String from;
    private String inter;
    private String to;

    public Hanoi(String from, String inter, String to) {
        this.from = from;
        this.inter = inter;
        this.to = to;
    }

    public void hanoiByRecursive(int n) {
        doTowers(n,from,inter,to);
    }

    private void doTowers(int topN,String from,String inter,String to) {
        if (topN <= 0) {
            System.out.println("输入的参数错误！");
            return;
        }
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to+" , 第 "+ ++i + " 次移动");
        } else {
            doTowers(topN - 1, from, to, inter); //from-->inter
            System.out.println("DIsk " + topN + " from " + from + " to " + to+" , 第 "+ ++i + " 次移动");
            doTowers(topN - 1, inter, from, to); //inter-->to
        }
    }
}
