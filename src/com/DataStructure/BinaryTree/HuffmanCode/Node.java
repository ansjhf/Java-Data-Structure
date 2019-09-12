package com.DataStructure.BinaryTree.HuffmanCode;

/**
 * 用来作为HuffMan树的结点结构。Node中包含一个Data对象、Node类的leftChild和rightChild，
 * 实现Comparable接口，方便排序比较。
 */
public class Node implements Comparable<Node> {

    private Node leftChild = null;
    private Data data = null;
    private Node rightChild = null;

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node data =" + data + "[left=" + leftChild + " , right=" + rightChild + "]";
    }

    @Override
    public int compareTo(Node o) {
        return this.data.compareTo(o.getData());
    }

}
