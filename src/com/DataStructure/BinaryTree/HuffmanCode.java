package com.DataStructure.BinaryTree;

public class HuffmanCode{


}

class HuffmanNode implements Comparable,Cloneable{
    private int key;
    private HuffmanNode left;
    private HuffmanNode right;
    private  HuffmanNode parent;

    public HuffmanNode(int key, HuffmanNode left, HuffmanNode right, HuffmanNode parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try {
            obj = (HuffmanNode) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return obj;
    }

    @Override
    public int compareTo(Object obj) {
        return this.key - ((HuffmanNode)obj).key;
    }
}