package com.DataStructure.BinaryTree.HuffmanCode;

import java.util.ArrayList;

public class HuffmanAlgorithmImpl extends HuffmanAlgorithmAbstract{
    /**
     * 创建哈夫曼树
     * @param letterList
     * @return
     */
    @Override
    protected Node createTree(ArrayList<Node> letterList) {
        init(letterList);
        while (letterList.size() != 1) {
            int size = letterList.size();
            Node nodeLeft = letterList.get(size - 1);
            Node nodeRight = letterList.get(size - 2);
            Node nodeParent = new Node();
            nodeParent.setLeftChild(nodeLeft);
            nodeParent.setRightChild(nodeRight);
            Data data = new Data();
            data.setFrequency(nodeRight.getData().getFrequency() +
                    nodeLeft.getData().getFrequency());
            nodeParent.setData(data);
            letterList.set(size - 2, nodeParent);
            letterList.remove(size - 1);
            sort(letterList);
        }
        Node rootNode = letterList.get(0);
        return rootNode;
    }

    /**
     * 初始化 让节点列表有序
     * @param letterList
     */
    private void init(ArrayList<Node> letterList) {
        sort(letterList);
    }

    /**
     * 冒泡排序，把小的放在最后
     * @param letterList
     */
    private void sort(ArrayList<Node> letterList) {
        int size = letterList.size();
        if (size == 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (letterList.get(j).getData().getFrequency() < letterList.get(j + 1).getData().getFrequency()) {
                    Node tempNode = letterList.get(j);
                    letterList.set(j, letterList.get(j + 1));
                    letterList.set(j + 1, tempNode);
                }
            }
        }
    }
}
