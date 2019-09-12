package com.DataStructure.BinaryTree.HuffmanCode;

/**
 * 用来存放每个字符。Data类包含字符的值以及其在文本中出现的次数，
 * 实现Comparable接口以及其比较方法，方便排序使用。
 */
public class Data implements Comparable<Data>{
    private char c = 0; //存放字符
    private int frequency = 0; //存放出现的次数

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    //重写toString方法方便查错时输出信息
    @Override
    public String toString() {
        return c + " " ;
    }

    @Override
    public int compareTo(Data o) {
        //用于比较两个Data对象出现的次数
        if (this.frequency < o.getFrequency()) {
            return -1;
        } else if (this.frequency > o.getFrequency()) {
            return 1;
        } else {
            return 0;
        }
    }
}
